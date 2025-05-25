package app.adapters.pet;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.person.entity.PersonEntity;
import app.adapters.person.repository.PersonRepository;
import app.adapters.pet.entity.PetEntity;
import app.adapters.pet.repository.PetRepository;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.ports.PetPort;

@Service
public class PetAdapter implements PetPort {

	@Autowired
    private PetRepository petRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void savePet(Pet pet) {
        PersonEntity owner = personRepository.findByDocument(pet.getPerson().getDocument());
        if (owner == null) {
            throw new RuntimeException("Persona no encontrada con documento: " + pet.getPerson().getDocument());
        }

        PetEntity entity = new PetEntity();
        entity.setPetName(pet.getPetName());
        entity.setAgePet(pet.getAgePet());
        entity.setSpecies(pet.getSpecies());
        entity.setBreed(pet.getBreed());
        entity.setCharacteristics(pet.getCharacteristics());
        entity.setWeight(pet.getWeight());
        entity.setDateCreated(Date.valueOf(pet.getDateCreated()));
        entity.setPerson(owner);

        petRepository.save(entity);
    }

    @Override
    public Pet findPetById(long petId) {
        PetEntity entity = petRepository.findById(petId).orElse(null);
        return (entity != null) ? toDomain(entity) : null;
    }

    @Override
    public List<Pet> findPetsByOwnerDocument(long ownerDocument) {
        List<PetEntity> pets = petRepository.findByPersonDocument(ownerDocument);
        return pets.stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void updatePet(Pet pet) {
        PetEntity existing = petRepository.findById(pet.getPetId()).orElse(null);
        if (existing == null) {
            throw new RuntimeException("Mascota no encontrada con ID: " + pet.getPetId());
        }

        existing.setPetName(pet.getPetName());
        existing.setAgePet(pet.getAgePet());
        existing.setSpecies(pet.getSpecies());
        existing.setBreed(pet.getBreed());
        existing.setCharacteristics(pet.getCharacteristics());
        existing.setWeight(pet.getWeight());
        existing.setDateCreated(Date.valueOf(pet.getDateCreated()));

        petRepository.save(existing);
    }

    private Pet toDomain(PetEntity entity) {
        Pet pet = new Pet();
        pet.setPetId(entity.getPetId());
        pet.setPetName(entity.getPetName());
        pet.setAgePet(entity.getAgePet());
        pet.setSpecies(entity.getSpecies());
        pet.setBreed(entity.getBreed());
        pet.setCharacteristics(entity.getCharacteristics());
        pet.setWeight(entity.getWeight());
        pet.setDateCreated(entity.getDateCreated().toLocalDate()); 
        if (entity.getPerson() != null) {
            Person person = new Person();
            person.setPersonId(entity.getPerson().getPersonId());
            person.setDocument(entity.getPerson().getDocument());
            person.setName(entity.getPerson().getName());
            person.setAge(entity.getPerson().getAge());
            pet.setPerson(person); 
        } else {
            pet.setPerson(null); 
        }

        return pet;
    }
}
