package app.adapters.pet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.domain.models.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
    List<Pet> findByPerson_Document(long document);
}