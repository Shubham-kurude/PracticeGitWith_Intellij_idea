package MahindraEnqueryApp.demo.service;

import MahindraEnqueryApp.demo.model.Enquiry;

import java.util.List;
import java.util.Optional;

public interface EnquiryService {
         Enquiry saveEnquiry(Enquiry enquiry);
         List<Enquiry> getAllEnquiries();
         Optional<Enquiry> getEnquiryById(Long id);
         Enquiry deleteEnquiryById(Long id);
}
