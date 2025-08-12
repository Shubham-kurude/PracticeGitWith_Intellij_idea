package MahindraEnqueryApp.demo.service;

import MahindraEnqueryApp.demo.model.Enquiry;
import MahindraEnqueryApp.demo.repository.EnquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
