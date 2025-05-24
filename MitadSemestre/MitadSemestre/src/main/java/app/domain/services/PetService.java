package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.Person;
import app.domain.models.Pet;
import app.exceptions.BussinesException;
import app.ports.PersonPort;
import app.ports.PetPort;

@Service
public class PetService {
	@Autowired
    private PetPort petPort;
	@Autowired
	private PersonPort personPort;

    public PetService(PetPort petPort) {
        this.petPort = petPort;
    }

    public void registerPet(Pet newPet) throws Exception {
    	long ownerDocument = newPet.getPerson().getDocument();
        Person existingPerson = personPort.findByDocument(ownerDocument);
        if (existingPerson == null) {
            throw new BussinesException("El propietario con documento " + ownerDocument + " no se encuentra registrado.");
        }
        
    	Person person = personPort.findByDocument(newPet.getPerson().getDocument());
    	newPet.setPerson(person);
    	
        petPort.savePet(newPet);
        
        System.out.println("La mascota ha sido registrada exitosamente.");
    }

    public Pet getPetById(long petId) throws Exception {
        Pet pet = petPort.findPetById(petId);
        if (pet == null) {
            throw new Exception("Mascota no encontrada");
        }
        return pet;
    }

    public List<Pet> getPetsByOwner(long ownerDocument) throws Exception {
        List<Pet> pets = petPort.findPetsByOwnerDocument(ownerDocument);
        if (pets == null || pets.isEmpty()) {
            throw new Exception("No se encontraron mascotas para este dueño");
        }
        return pets;
    }
}