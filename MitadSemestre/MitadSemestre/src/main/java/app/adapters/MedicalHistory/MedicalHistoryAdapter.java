package app.adapters.MedicalHistory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.MedicalHistory.entity.MedicalHistoryEntity;
import app.adapters.MedicalHistory.repository.MedicalHistoryRepository;
import app.adapters.pet.entity.PetEntity;
import app.adapters.pet.repository.PetRepository;
import app.adapters.user.entity.UserEntity;
import app.adapters.user.repository.UserRepository;
import app.domain.models.MedicalHistory;
import app.domain.models.Pet;
import app.domain.models.User;
import app.ports.MedicalHistoryPort;
import jakarta.persistence.EntityNotFoundException;

@Service
public class MedicalHistoryAdapter implements MedicalHistoryPort {

    @Autowired
    private MedicalHistoryRepository medicalHistoryRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveMedicalHistory(MedicalHistory medicalHistory) {
        PetEntity petEntity = petRepository.findById(medicalHistory.getPet().getPetId())
                .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada con ID: " + medicalHistory.getPet().getPetId()));

        
        UserEntity veterinarianEntity = userRepository.findById(medicalHistory.getVeterinarian().getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Veterinario no encontrado con ID: " + medicalHistory.getVeterinarian().getUserId()));

        MedicalHistoryEntity entity = toEntity(medicalHistory, petEntity, veterinarianEntity);
        medicalHistoryRepository.save(entity);
    }

    @Override
    public MedicalHistory findMedicalHistoryByPetId(long petId) {
        return medicalHistoryRepository.findByPet_PetId(petId)
                .stream()
                .map(this::toDomain)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<MedicalHistory> findAllMedicalHistoriesByPetId(long petId) {
        List<MedicalHistoryEntity> entities = medicalHistoryRepository.findByPet_PetId(petId);
        return entities.stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void updateMedicalHistory(MedicalHistory medicalHistory) {
        MedicalHistoryEntity existingEntity = medicalHistoryRepository.findById(medicalHistory.getId())
                .orElseThrow(() -> new EntityNotFoundException("Historia médica no encontrada con ID: " + medicalHistory.getId()));
        existingEntity.setReasonConsult(medicalHistory.getReasonConsult());
        existingEntity.setSymptomatology(medicalHistory.getSymptomatology());
        existingEntity.setDiagnosis(medicalHistory.getDiagnosis());
        existingEntity.setProcedure(medicalHistory.getProcedure());
        existingEntity.setMedication(medicalHistory.getMedication());
        existingEntity.setMedicationDosage(medicalHistory.getMedicationDosage());
        existingEntity.setVaccinationRecordString(String.join(",", medicalHistory.getVaccinationRecord()));
        existingEntity.setAllergyMedications(medicalHistory.getAllergyMedications());
        existingEntity.setProcedureDetail(medicalHistory.getProcedureDetail());
        existingEntity.setConsultDate(Date.valueOf(medicalHistory.getConsultDate()));

        medicalHistoryRepository.save(existingEntity);
    }

    @Override
    public void deleteMedicalHistory(long medicalHistoryId) {
        if (!medicalHistoryRepository.existsById(medicalHistoryId)) {
            throw new EntityNotFoundException("Historia médica no encontrada con ID: " + medicalHistoryId);
        }
        medicalHistoryRepository.deleteById(medicalHistoryId);
    }
    private MedicalHistoryEntity toEntity(MedicalHistory domain, PetEntity petEntity, UserEntity veterinarianEntity) {
        MedicalHistoryEntity entity = new MedicalHistoryEntity();
        if (domain.getId() != null) {
            entity.setId(domain.getId());
        }
        entity.setPet(petEntity);
        entity.setVeterinarian(veterinarianEntity);
        entity.setReasonConsult(domain.getReasonConsult());
        entity.setSymptomatology(domain.getSymptomatology());
        entity.setDiagnosis(domain.getDiagnosis());
        entity.setProcedure(domain.getProcedure());
        entity.setMedication(domain.getMedication());
        entity.setMedicationDosage(domain.getMedicationDosage());
        entity.setVaccinationRecordString(String.join(",", domain.getVaccinationRecord()));
        entity.setAllergyMedications(domain.getAllergyMedications());
        entity.setProcedureDetail(domain.getProcedureDetail());
        entity.setConsultDate(domain.getConsultDate() != null ? Date.valueOf(domain.getConsultDate()) : Date.valueOf(LocalDate.now()));
        return entity;
    }

    private MedicalHistory toDomain(MedicalHistoryEntity entity) {
        MedicalHistory domain = new MedicalHistory();
        domain.setId(entity.getId());

        if (entity.getPet() != null) {
            Pet petDomain = new Pet();
            petDomain.setPetId(entity.getPet().getPetId());
            petDomain.setPetName(entity.getPet().getPetName());
            domain.setPet(petDomain);
        }

        if (entity.getVeterinarian() != null) {
            User userDomain = new User();
            userDomain.setUserId(entity.getVeterinarian().getUserId());
            userDomain.setUserName (entity.getVeterinarian().getUserName());
            domain.setVeterinarian(userDomain);
        }

        domain.setReasonConsult(entity.getReasonConsult());
        domain.setSymptomatology(entity.getSymptomatology());
        domain.setDiagnosis(entity.getDiagnosis());
        domain.setProcedure(entity.getProcedure());
        domain.setMedication(entity.getMedication());
        domain.setMedicationDosage(entity.getMedicationDosage());
        domain.setVaccinationRecord(Arrays.asList(entity.getVaccinationRecordString().split(",")));
        domain.setAllergyMedications(entity.getAllergyMedications());
        domain.setProcedureDetail(entity.getProcedureDetail());
        domain.setConsultDate(entity.getConsultDate().toLocalDate());
        return domain;
    }
}
