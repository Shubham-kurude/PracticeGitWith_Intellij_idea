package MahindraEnqueryApp.demo.service;

import MahindraEnqueryApp.demo.model.Enquiry;
import MahindraEnqueryApp.demo.repository.EnquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnquiryServiceImpl implements EnquiryService{

    private final EnquiryRepository repository;

    public EnquiryServiceImpl(EnquiryRepository repository) {
        this.repository = repository;
    }

    @Override
    public Enquiry saveEnquiry(Enquiry enquiry) {
        return repository.save(enquiry);
    }

    @Override
    public List<Enquiry> getAllEnquiries() {
        return repository.findAll();
    }

    @Override
    public Optional<Enquiry> getEnquiryById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Enquiry deleteEnquiryById(Long id) {
        Enquiry enquiry = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("id not found "));
        repository.delete(enquiry);
        return enquiry;
    }


}
