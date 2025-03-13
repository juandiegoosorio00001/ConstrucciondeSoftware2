package ports;

import app.domain.models.MedicalHistory;
import java.util.List;

public interface MedicalHistoryPort {

    void saveMedicalHistory(MedicalHistory medicalHistory);

    MedicalHistory findMedicalHistoryByMascotId(long mascotId);

    List<MedicalHistory> findAllMedicalHistoriesByMascotId(long mascotId);

    void updateMedicalHistory(MedicalHistory medicalHistory);

    void deleteMedicalHistory(long mascotId);
}

