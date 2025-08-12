package MahindraEnqueryApp.demo.restcontroller;

import MahindraEnqueryApp.demo.model.Enquiry;
import MahindraEnqueryApp.demo.service.EnquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/enquiries")
public class RestController {

    private final EnquiryService service;

    public RestController(EnquiryService service) {
        this.service = service;
    }


    @PostMapping("/create")
    public ResponseEntity<Enquiry> createEnquiry(@RequestBody Enquiry enquiry){
        return new ResponseEntity<>(service.saveEnquiry(enquiry), HttpStatus.CREATED);
    }

    @GetMapping("/getAllEnquiries")
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        List<Enquiry> enquiries = service.getAllEnquiries();

        if (enquiries.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(enquiries); // 200 OK
        }
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<?> findEnquiryById(@PathVariable Long id) {
        Optional<Enquiry> enquiry = service.getEnquiryById(id);

        if (enquiry.isPresent()) {
            return ResponseEntity.ok(enquiry.get()); // 200 OK
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Enquiry with ID " + id + " not found");
            error.put("status", "404");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Enquiry> deleteEnquiryByid(@PathVariable Long id){
        Enquiry deletedEnquiry = service.deleteEnquiryById(id);
        return new ResponseEntity<>(deletedEnquiry, HttpStatus.OK);
    }

}
