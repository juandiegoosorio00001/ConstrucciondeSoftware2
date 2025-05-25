package app.adapters.MedicalHistory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.adapters.MedicalHistory.entity.MedicalHistoryEntity;

@Repository
public interface MedicalHistoryRepository extends JpaRepository<MedicalHistoryEntity, Long> {
    List<MedicalHistoryEntity> findByPet_PetId(Long petId);
}