package app.ports;

import app.domain.models.Pet;
import java.util.List;
import org.springframework.stereotype.Service;

public interface PetPort {
    void savePet(Pet pet);
    Pet findPetById(long petId);
    List<Pet> findPetsByOwnerDocument(long ownerDocument);
    void updatePet(Pet pet);
}