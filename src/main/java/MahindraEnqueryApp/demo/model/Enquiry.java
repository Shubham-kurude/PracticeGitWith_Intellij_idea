package MahindraEnqueryApp.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name="mahindraEnquiries")
public class Enquiry  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String vehicleModel;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();
}
