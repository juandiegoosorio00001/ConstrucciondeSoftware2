package app.adapters.MedicalHistory.entity;

import app.adapters.pet.entity.PetEntity;
import app.adapters.user.entity.UserEntity;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "medical_history")
public class MedicalHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private UserEntity veterinarian;

    @Column(name = "reason_consult")
    private String reasonConsult;

    @Column(name = "symptomatology")
    private String symptomatology;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "procedure_done")
    private String procedure;

    @Column(name = "medication")
    private String medication;

    @Column(name = "medication_dosage")
    private String medicationDosage;

    @Column(name = "vaccination_record")
    private String vaccinationRecordString;

    @Column(name = "allergy_medications")
    private String allergyMedications;

    @Column(name = "procedure_detail")
    private String procedureDetail;

    @Column(name = "consult_date") 
    private Date consultDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public UserEntity getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(UserEntity veterinarian) {
		this.veterinarian = veterinarian;
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

	public String getVaccinationRecordString() {
		return vaccinationRecordString;
	}

	public void setVaccinationRecordString(String vaccinationRecordString) {
		this.vaccinationRecordString = vaccinationRecordString;
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

	public Date getConsultDate() {
		return consultDate;
	}

	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}
}
