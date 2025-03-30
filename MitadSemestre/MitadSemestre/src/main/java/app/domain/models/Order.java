package app.domain.models;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	 private long orderId;
	    private Pet pet;       
	    private User owner;    
	    private User veterinarian; 
	    private String medicationName; 
	    private String medicationDosage; 
	    private Date generationDate;  
	    private MedicalHistory medicalHistory;
	
}
