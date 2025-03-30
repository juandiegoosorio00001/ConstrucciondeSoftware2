package app.domain.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicalHistory {
    public Pet pet;
    public String reasonConsult;
    public String symptomatology;
    public String diagnosis;
    public String procedure;
    public String medication;
    public String medicationDosage;
    public String idOrder;
    public List<String> vaccinationRecord;
    public String allergyMedications;
    public String procedureDetail;
    public boolean orderCancellation;
	public MedicalHistory(Pet pet, String reasonConsult, String symptomatology, String diagnosis, String procedure,
			String medication, String medicationDosage, String idOrder, List<String> vaccinationRecord,
			String allergyMedications, String procedureDetail, boolean orderCancellation) {
		super();
		this.pet = pet;
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
	}
 
}