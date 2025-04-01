package app.adapters.pet;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.models.Pet;
import app.ports.PetPort;

@Service
public class PetAdapter implements PetPort {

	@Override
	public void savePet(Pet pet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pet findPetById(long petId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pet> findPetsByOwnerDocument(long ownerDocument) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePet(Pet pet) {
		// TODO Auto-generated method stub
		
	}

}
