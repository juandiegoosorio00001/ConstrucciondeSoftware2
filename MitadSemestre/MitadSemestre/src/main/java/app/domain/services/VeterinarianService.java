package app.domain.services;

import app.domain.models.MedicalHistory;
import app.domain.models.Order;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.MedicalHistoryPort;
import app.ports.OrderPort;
import app.ports.PetPort;
import java.util.List;

public class VeterinarianService {

    private PetPort petPort;
    private MedicalHistoryPort medicalHistoryPort;
    private OrderPort orderPort;

    public VeterinarianService(PetPort petPort, MedicalHistoryPort medicalHistoryPort, OrderPort orderPort) {
        this.petPort = petPort;
        this.medicalHistoryPort = medicalHistoryPort;
        this.orderPort = orderPort;
    }

    public void makeConsult(User veterinarian, long petId, String reasonConsult, String symptomatology, 
                            String diagnosis, String procedure, String medication, String medicationDosage,
                            List<String> vaccinationRecord, String allergyMedications, String procedureDetail) throws Exception {
        
        Pet pet = petPort.findPetById(petId);
        if (pet == null) {
            throw new Exception("Mascota no encontrada");
        }

        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPet(pet);
        medicalHistory.setReasonConsult(reasonConsult);
        medicalHistory.setSymptomatology(symptomatology);
        medicalHistory.setDiagnosis(diagnosis);
        medicalHistory.setProcedure(procedure);
        medicalHistory.setMedication(medication);
        medicalHistory.setMedicationDosage(medicationDosage);
        medicalHistory.setVaccinationRecord(vaccinationRecord);
        medicalHistory.setAllergyMedications(allergyMedications);
        medicalHistory.setProcedureDetail(procedureDetail);
        medicalHistory.setOrderCancellation(false);  
        medicalHistoryPort.saveMedicalHistory(medicalHistory);
    }
    public void createOrder(User veterinarian, long petId, String reasonConsult, String symptomatology, 
            String diagnosis, String procedure, String medication, String medicationDosage,
            List<String> vaccinationRecord, String allergyMedications, String procedureDetail) throws Exception{
    	Pet pet = petPort.findPetById(petId);
        if (pet == null) {
            throw new Exception("Mascota no encontrada");
        }
        MedicalHistory medicalHistory = new MedicalHistory();
    	Order order = new Order();
        order.setPet(pet);
        order.setMedicalHistory(medicalHistory);
        order.setMedicationName(medication);  
        order.setMedicationDosage(medicationDosage);  
        order.setOwner(pet.getPerson());
        order.setVeterinarian(veterinarian); 
        order.setGenerationDate(pet.getDateCreated());
        orderPort.saveOrder(order);
    }
}