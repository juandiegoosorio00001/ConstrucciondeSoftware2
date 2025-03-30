package app.domain.services;

import app.domain.models.Pet;
import app.ports.PetPort;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PetService {
    private PetPort petPort;

    public PetService(PetPort petPort) {
        this.petPort = petPort;
    }

    public void registerPet(Pet newPet) throws Exception {

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