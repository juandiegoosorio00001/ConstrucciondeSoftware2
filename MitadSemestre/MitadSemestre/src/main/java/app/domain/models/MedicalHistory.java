package app.domain.models;

import java.util.List;

public class MedicalHistory {
    private final Mascot mascot;
    private final Veterinarian veterinarian;
    private final String reasonConsult;
    private final String symptomatology;
    private final String diagnosis;
    private final String procedure;
    private final String medication;
    private final String medicationDosage;
    private final String idOrder;
    private final List<String> vaccinationRecord;
    private final String allergyMedications;
    private final String procedureDetail;
    private final boolean orderCancellation;
    
	public MedicalHistory(Mascot mascot, Veterinarian veterinarian, String reasonConsult, String symptomatology,
			String diagnosis, String procedure, String medication, String medicationDosage, String idOrder,
			List<String> vaccinationRecord, String allergyMedications, String procedureDetail,
			boolean orderCancellation) {
		super();
		this.mascot = mascot;
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
	}

    
}