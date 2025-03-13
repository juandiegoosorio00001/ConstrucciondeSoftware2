package services;

import app.domain.models.MedicalHistory;
import app.domain.models.Mascot;
import app.domain.models.Order;
import app.domain.models.User;
import ports.MedicalHistoryPort;
import ports.MascotPort;
import ports.OrderPort;
import java.util.List;

public class VeterinarianService {

    private MascotPort mascotPort;
    private MedicalHistoryPort medicalHistoryPort;
    private OrderPort orderPort;

    public VeterinarianService(MascotPort mascotPort, MedicalHistoryPort medicalHistoryPort, OrderPort orderPort) {
        this.mascotPort = mascotPort;
        this.medicalHistoryPort = medicalHistoryPort;
        this.orderPort = orderPort;
    }

    public void makeConsult(User veterinarian, long mascotId, String reasonConsult, String symptomatology, 
                            String diagnosis, String procedure, String medication, String medicationDosage,
                            List<String> vaccinationRecord, String allergyMedications, String procedureDetail) throws Exception {
        
        Mascot mascot = mascotPort.findMascotById(mascotId);
        if (mascot == null) {
            throw new Exception("Mascota no encontrada");
        }

        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setMascot(mascot);
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
        Order order = new Order();
        order.setMascot(mascot);
        order.setMedicalHistory(medicalHistory);
        orderPort.saveOrder(order);
    }
}