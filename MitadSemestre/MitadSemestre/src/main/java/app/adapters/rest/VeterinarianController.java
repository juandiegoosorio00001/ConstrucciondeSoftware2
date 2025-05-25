package app.adapters.rest;

import app.adapters.rest.request.ConsultRequest;
import app.adapters.rest.request.PetRequest;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.services.PetService;
import app.domain.services.VeterinarianService;
import app.exceptions.BussinesException;
import app.exceptions.InputsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/veterinarian")
public class VeterinarianController {

    @Autowired
    private VeterinarianService veterinarianService;
    @Autowired
    private PetService petService;
    
    @PostMapping("/petRegister")
    public ResponseEntity registerPet(@RequestBody PetRequest request) {
        try {
            Pet pet = new Pet();
            pet.setPetName(request.getPetName());
            pet.setAgePet(request.getAgePet());
            pet.setBreed(request.getBreed());
            pet.setCharacteristics(request.getCharacteristics());
            pet.setDateCreated(request.getDateCreated());
            pet.setSpecies(request.getSpecies());
            pet.setWeight(request.getWeight());
            Person person = new Person();
            person.setDocument(request.getPerson());
            pet.setPerson(person);  
            petService.registerPet(pet);
            return new ResponseEntity("se ha creado la mascota",HttpStatus.OK);
    	}catch(BussinesException be) {
    		return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
    	}catch(InputsException ie) {
    		return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
    	}catch(Exception e) {
    		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @PostMapping("/consult")
    public ResponseEntity<String> makeConsultAndOrder(@RequestBody ConsultRequest request) {
        try {
            veterinarianService.makeConsultAndCreateOrder(
                request.getVeterinarian(),
                request.getPetId(),
                request.getReasonConsult(),
                request.getSymptomatology(),
                request.getDiagnosis(),
                request.getProcedure(),
                request.getMedication(),
                request.getMedicationDosage(),
                request.getVaccinationRecord(),
                request.getAllergyMedications(),
                request.getProcedureDetail()
            );
            return new ResponseEntity<>("Consulta y Orden registradas exitosamente.", HttpStatus.CREATED);
        } catch (Exception e) { 
            return new ResponseEntity<>("Error al registrar la consulta y la orden: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

