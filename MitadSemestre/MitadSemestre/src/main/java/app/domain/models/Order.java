package app.domain.models;

import java.time.LocalDate; // Usar LocalDate para fechas sin tiempo
// import java.sql.Date; // Eliminar esta importación

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private Long orderId;
    private Pet pet;
    private Person owner;
    private User veterinarian; 
    private String medicationName;
    private String medicationDosage;
    private LocalDate generationDate;
    private MedicalHistory medicalHistory;
    private String orderStatus; 
    private String cancellationReason;
    private LocalDate cancellationDate;
	public Order(Long orderId, Pet pet, Person owner, User veterinarian, String medicationName, String medicationDosage,
			LocalDate generationDate, MedicalHistory medicalHistory, String orderStatus, String cancellationReason,
			LocalDate cancellationDate) {
		super();
		this.orderId = orderId;
		this.pet = pet;
		this.owner = owner;
		this.veterinarian = veterinarian;
		this.medicationName = medicationName;
		this.medicationDosage = medicationDosage;
		this.generationDate = generationDate;
		this.medicalHistory = medicalHistory;
		this.orderStatus = orderStatus;
		this.cancellationReason = cancellationReason;
		this.cancellationDate = cancellationDate;
	} 
    
}