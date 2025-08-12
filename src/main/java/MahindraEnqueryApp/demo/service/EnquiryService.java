package MahindraEnqueryApp.demo.service;

import MahindraEnqueryApp.demo.model.Enquiry;

import java.util.List;

public interface EnquiryService {
        public Enquiry saveEnquiry(Enquiry enquiry);
        public List<Enquiry> getAllEnquiries();
}
