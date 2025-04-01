package app.adapters.inputs;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.Utils.Utils;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.services.VeterinarianService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@NoArgsConstructor
@Setter
@Getter
public class VeterinarianInput implements InputPort {
	
	@Autowired
	private VeterinarianService veterinarianService;
	
        
	private final String MENU = "Ingrese la opcion:" + " \n 1. Hacer Consulta. \\n 2. Emitir Orden. \\n 3. Cerrar Sesion";
	 User user = new User();
        public void menu() {
    		boolean sesion = true;
    		while (sesion) {
    			sesion = options();
    		}
    	}
        private boolean options() {
    		try {
    			System.out.println(MENU);
    			String option = Utils.getReader().nextLine();
    			switch (option) {
    			case "1": {
    					this.createOrder();
    					return true;
    			}
    			case "2":{
    				this.createMedicalConsultation();
    				return true;
    			}
    			case "3" :{
    				System.out.println("Se ha cerrado sesion");
    				return false;
    			}
    			default:
    				System.out.println("opcion no valida");
    				return true;
    			}
    		} catch (Exception e) {
    			System.out.println(e.getMessage());
    			return true;
    		}
    	}

    private static Pet getPetData() {
       
        System.out.println("Ingrese los datos de la mascota:");

        System.out.print("ID de la Mascota: ");
        long petId = Utils.getReader().nextLong();
        Utils.getReader().nextLine();

        Pet pet = new Pet();
        pet.setPetId(petId);
        return pet;
    }

    private void createMedicalConsultation() {
       
        System.out.print("Motivo de la consulta: ");
        String reasonConsult = Utils.getReader().nextLine();

        System.out.print("Sintomatología: ");
        String symptomatology = Utils.getReader().nextLine();

        System.out.print("Diagnóstico: ");
        String diagnosis = Utils.getReader().nextLine();

        System.out.print("Procedimiento: ");
        String procedure = Utils.getReader().nextLine();

        System.out.print("Medicamento: ");
        String medication = Utils.getReader().nextLine();

        System.out.print("Dosis del medicamento: ");
        String medicationDosage = Utils.getReader().nextLine();

        System.out.print("Registro de vacunación: ");
        String vaccinationRecordInput = Utils.getReader().nextLine();
        List<String> vaccinationRecord = List.of(vaccinationRecordInput.split(","));

        System.out.print("Medicamentos para alergias: ");
        String allergyMedications = Utils.getReader().nextLine();

        System.out.print("Detalles del procedimiento: ");
        String procedureDetail = Utils.getReader().nextLine();

        Pet pet = getPetData();

        try {
            veterinarianService.makeConsult(user, pet.getPetId(), reasonConsult, symptomatology, diagnosis, 
                                           procedure, medication, medicationDosage, vaccinationRecord, 
                                           allergyMedications, procedureDetail);
            System.out.println("Consulta registrada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al registrar la consulta: " + e.getMessage());
        }
    }

    private void createOrder() {
        System.out.print("Motivo de la orden: ");
        String reasonConsult = Utils.getReader().nextLine();

        System.out.print("Sintomatología: ");
        String symptomatology = Utils.getReader().nextLine();

        System.out.print("Diagnóstico: ");
        String diagnosis = Utils.getReader().nextLine();

        System.out.print("Procedimiento: ");
        String procedure = Utils.getReader().nextLine();

        System.out.print("Medicamento: ");
        String medication = Utils.getReader().nextLine();

        System.out.print("Dosis del medicamento: ");
        String medicationDosage = Utils.getReader().nextLine();

        System.out.print("Registro de vacunación (separado por comas): ");
        String vaccinationRecordInput = Utils.getReader().nextLine();
        List<String> vaccinationRecord = List.of(vaccinationRecordInput.split(","));

        System.out.print("Medicamentos para alergias: ");
        String allergyMedications = Utils.getReader().nextLine();

        System.out.print("Detalles del procedimiento: ");
        String procedureDetail = Utils.getReader().nextLine();

        Pet pet = getPetData();
        

        try {
            veterinarianService.createOrder(user, pet.getPetId(), reasonConsult, symptomatology, diagnosis, 
                                           procedure, medication, medicationDosage, vaccinationRecord, 
                                           allergyMedications, procedureDetail);
            System.out.println("Orden creada con éxito.");
        } catch (Exception e) {
            System.out.println("Error al crear la orden: " + e.getMessage());
        }
    }
}