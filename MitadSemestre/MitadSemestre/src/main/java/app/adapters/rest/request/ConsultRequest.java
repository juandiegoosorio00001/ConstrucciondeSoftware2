package app.adapters.rest.request;

import java.util.List;

import app.domain.models.User;

public class ConsultRequest {
	 	private User veterinarian; 
	    private long petId;
	    private String reasonConsult;
	    private String symptomatology;
	    private String diagnosis;
	    private String procedure;
	    private String medication;
	    private String medicationDosage;
	    private List<String> vaccinationRecord;
	    private String allergyMedications;
	    private String procedureDetail;
	public User getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(User veterinarian) {
		this.veterinarian = veterinarian;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public String getReasonConsult() {
		return reasonConsult;
	}
	public void setReasonConsult(String reasonConsult) {
		this.reasonConsult = reasonConsult;
	}
	public String getSymptomatology() {
		return symptomatology;
	}
	public void setSymptomatology(String symptomatology) {
		this.symptomatology = symptomatology;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getMedicationDosage() {
		return medicationDosage;
	}
	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}
	public List<String> getVaccinationRecord() {
		return vaccinationRecord;
	}
	public void setVaccinationRecord(List<String> vaccinationRecord) {
		this.vaccinationRecord = vaccinationRecord;
	}
	public String getAllergyMedications() {
		return allergyMedications;
	}
	public void setAllergyMedications(String allergyMedications) {
		this.allergyMedications = allergyMedications;
	}
	public String getProcedureDetail() {
		return procedureDetail;
	}
	public void setProcedureDetail(String procedureDetail) {
		this.procedureDetail = procedureDetail;
	}
    
}