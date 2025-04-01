package app.adapters.MedicalHistory;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.models.MedicalHistory;
import app.ports.MedicalHistoryPort;
@Service
public class MedicalHistoryAdapter implements MedicalHistoryPort {

	@Override
	public void saveMedicalHistory(MedicalHistory medicalHistory) {
		
	}

	@Override
	public MedicalHistory findMedicalHistoryByPetId(long petId) {
		return null;
	}

	@Override
	public List<MedicalHistory> findAllMedicalHistoriesByPetId(long petId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMedicalHistory(MedicalHistory medicalHistory) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMedicalHistory(long petId) {
		// TODO Auto-generated method stub
		
	}

}
