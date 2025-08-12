package MahindraEnqueryApp.demo.repository;

import MahindraEnqueryApp.demo.model.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository  extends JpaRepository<Enquiry ,Long> {

}
