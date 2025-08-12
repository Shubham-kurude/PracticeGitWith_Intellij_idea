package MahindraEnqueryApp.demo.restcontroller;

import MahindraEnqueryApp.demo.model.Enquiry;
import MahindraEnqueryApp.demo.service.EnquiryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
//    public ResponseEntity<Enquiry> getAllEnquiries(){
//        return new ResponseEntity<>(service.getAllEnquiries(),HttpStatus.)
//    }
    public ResponseEntity<List<Enquiry>> getAllEnquiries() {
        List<Enquiry> enquiries = service.getAllEnquiries();

        if (enquiries.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.ok(enquiries); // 200 OK
        }
    }
}
