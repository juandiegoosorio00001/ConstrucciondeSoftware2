package app.domain.services;

import app.domain.models.MedicalHistory;
import app.domain.models.Order;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.MedicalHistoryPort;
import app.ports.OrderPort;
import app.ports.PetPort;
import app.ports.UserPort;
import jakarta.persistence.EntityNotFoundException;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class VeterinarianService {
	@Autowired
    private PetPort petPort;
	@Autowired
    private MedicalHistoryPort medicalHistoryPort;
	@Autowired
	private OrderPort orderPort;
	@Autowired
    private UserPort userPort;
	

    public VeterinarianService(PetPort petPort, MedicalHistoryPort medicalHistoryPort, OrderPort orderPort, UserPort userPort) {
        this.petPort = petPort;
        this.medicalHistoryPort = medicalHistoryPort;
        this.orderPort = orderPort;
        this.userPort = userPort;
    }

    public void makeConsult(
    		User veterinarianFromRequest,
            long petId,
            String reasonConsult,
            String symptomatology,
            String diagnosis,
            String procedure,
            String medication,
            String medicationDosage,
            String idOrder, 
            List<String> vaccinationRecord,
            String allergyMedications,
            String procedureDetail,
            boolean orderCancellation
    		)
    {
        Pet existingPet = petPort.findPetById(petId);
        if (existingPet == null) {
            throw new EntityNotFoundException("Mascota no encontrada con ID: " + petId);
        }
        User existingVeterinarian = userPort.findUserById(veterinarianFromRequest.getUserId());
        if (existingVeterinarian == null) {
            throw new EntityNotFoundException("Veterinario no encontrado con ID: " + veterinarianFromRequest.getUserId());
        }
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPet(existingPet);
        medicalHistory.setVeterinarian(existingVeterinarian);
        medicalHistory.setReasonConsult(reasonConsult);
        medicalHistory.setSymptomatology(symptomatology);
        medicalHistory.setDiagnosis(diagnosis);
        medicalHistory.setProcedure(procedure);
        medicalHistory.setMedication(medication);
        medicalHistory.setMedicationDosage(medicationDosage);
        medicalHistory.setVaccinationRecord(vaccinationRecord);
        medicalHistory.setAllergyMedications(allergyMedications);
        medicalHistory.setProcedureDetail(procedureDetail);
        medicalHistory.setConsultDate(LocalDate.now());
        medicalHistoryPort.saveMedicalHistory(medicalHistory);
    }

    public void makeConsultAndCreateOrder(
            User veterinarianFromRequest,
            long petId,
            String reasonConsult,
            String symptomatology,
            String diagnosis,
            String procedure,
            String medication,
            String medicationDosage, 
            List<String> vaccinationRecord,
            String allergyMedications,
            String procedureDetail
    ) {
        Pet existingPet = petPort.findPetById(petId);
        if (existingPet == null) {
            throw new EntityNotFoundException("Mascota no encontrada con ID: " + petId);
        }
        User existingVeterinarian = userPort.findUserById(veterinarianFromRequest.getUserId());
        if (existingVeterinarian == null) {
            throw new EntityNotFoundException("Veterinario no encontrado con ID: " + veterinarianFromRequest.getUserId());
        }
        
        MedicalHistory medicalHistory = new MedicalHistory();
        medicalHistory.setPet(existingPet);
        medicalHistory.setVeterinarian(existingVeterinarian);
        medicalHistory.setReasonConsult(reasonConsult);
        medicalHistory.setSymptomatology(symptomatology);
        medicalHistory.setDiagnosis(diagnosis);
        medicalHistory.setProcedure(procedure);
        medicalHistory.setMedication(medication);
        medicalHistory.setMedicationDosage(medicationDosage);
        medicalHistory.setVaccinationRecord(vaccinationRecord);
        medicalHistory.setAllergyMedications(allergyMedications);
        medicalHistory.setProcedureDetail(procedureDetail);
        medicalHistory.setConsultDate(LocalDate.now());
        
        medicalHistoryPort.saveMedicalHistory(medicalHistory);
        Order order = new Order();
        order.setPet(existingPet); 
        order.setOwner(existingPet.getPerson());
        order.setVeterinarian(existingVeterinarian); 
        order.setMedicationName(medication);
        order.setMedicationDosage(medicationDosage);
        order.setGenerationDate(LocalDate.now());
        order.setMedicalHistory(medicalHistory);
        order.setOrderStatus("PENDIENTE");

        orderPort.saveOrder(order);
    }
    public void annulOrder(Long orderId, String cancellationReason, User annullingUser) {
        Order order = orderPort.findOrderById(orderId);
        if (order == null) {
            throw new EntityNotFoundException("Orden no encontrada con ID: " + orderId);
        }
        if (!order.getOrderStatus().equals("ANULADA")) {
            order.setOrderStatus("ANULADA");
            order.setCancellationReason(cancellationReason);
            order.setCancellationDate(LocalDate.now());
            orderPort.updateOrder(order);
            MedicalHistory medicalHistory = order.getMedicalHistory();
            if (medicalHistory != null) {
                // Aquí podrías añadir una nota a la historia médica existente
                // Por ejemplo, añadiendo un nuevo registro o actualizando un campo de texto
                // medicalHistory.setNotes(medicalHistory.getNotes() + "\nOrden " + order.getOrderId() + " anulada: " + cancellationReason);
                // medicalHistoryPort.updateMedicalHistory(medicalHistory); // Si tienes un update para notas
            }
        }
    }
}