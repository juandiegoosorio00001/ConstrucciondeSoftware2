package app.ports;

import app.domain.models.MedicalHistory;
import java.util.List;

public interface MedicalHistoryPort {

    void saveMedicalHistory(MedicalHistory medicalHistory);

    MedicalHistory findMedicalHistoryByPetId(long petId);

    List<MedicalHistory> findAllMedicalHistoriesByPetId(long petId);

    void updateMedicalHistory(MedicalHistory medicalHistory);

    void deleteMedicalHistory(long petId);
}

