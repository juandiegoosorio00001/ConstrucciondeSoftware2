package app.domain.models;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicalHistory {
	private Long id; 
    private Pet pet;
    private User veterinarian;
    private String reasonConsult;
    private String symptomatology;
    private String diagnosis;
    private String procedure;
    private String medication;
    private String medicationDosage;
    private String idOrder;
    private List<String> vaccinationRecord;
    private String allergyMedications;
    private String procedureDetail;
    private boolean orderCancellation;
    private LocalDate consultDate;
	public MedicalHistory(Long id, Pet pet, User veterinarian, String reasonConsult, String symptomatology,
			String diagnosis, String procedure, String medication, String medicationDosage, String idOrder,
			List<String> vaccinationRecord, String allergyMedications, String procedureDetail,
			boolean orderCancellation, LocalDate consultDate) {
		super();
		this.id = id;
		this.pet = pet;
		this.veterinarian = veterinarian;
		this.reasonConsult = reasonConsult;
		this.symptomatology = symptomatology;
		this.diagnosis = diagnosis;
		this.procedure = procedure;
		this.medication = medication;
		this.medicationDosage = medicationDosage;
		this.idOrder = idOrder;
		this.vaccinationRecord = vaccinationRecord;
		this.allergyMedications = allergyMedications;
		this.procedureDetail = procedureDetail;
		this.orderCancellation = orderCancellation;
		this.consultDate = consultDate;
	}
    
    
}