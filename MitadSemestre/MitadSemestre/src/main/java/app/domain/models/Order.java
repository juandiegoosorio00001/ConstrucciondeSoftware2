package app.domain.models;

import java.time.LocalDate;

public class Order {
	 private long orderId;
	    private Pet pet;       
	    private Person owner;    
	    private User veterinarian; 
	    private String medicationName; 
	    private String medicationDosage; 
	    private LocalDate generationDate;  
	    private MedicalHistory medicalHistory;
		public long getOrderId() {
			return orderId;
		}
		public void setOrderId(long orderId) {
			this.orderId = orderId;
		}
		public Pet getPet() {
			return pet;
		}
		public void setPet(Pet pet) {
			this.pet = pet;
		}
		public Person getOwner() {
			return owner;
		}
		public void setOwner(Person owner) {
			this.owner = owner;
		}
		public User getVeterinarian() {
			return veterinarian;
		}
		public void setVeterinarian(User veterinarian) {
			this.veterinarian = veterinarian;
		}
		public String getMedicationName() {
			return medicationName;
		}
		public void setMedicationName(String medicationName) {
			this.medicationName = medicationName;
		}
		public String getMedicationDosage() {
			return medicationDosage;
		}
		public void setMedicationDosage(String medicationDosage) {
			this.medicationDosage = medicationDosage;
		}
		public LocalDate getGenerationDate() {
			return generationDate;
		}
		public void setGenerationDate(LocalDate generationDate) {
			this.generationDate = generationDate;
		}
		public MedicalHistory getMedicalHistory() {
			return medicalHistory;
		}
		public void setMedicalHistory(MedicalHistory medicalHistory) {
			this.medicalHistory = medicalHistory;
		}
	    
}
