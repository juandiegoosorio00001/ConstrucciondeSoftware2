package app.domain.models;

public class Order {
	private long OrderId;
	private Mascot Mascot;
	private OwnerMascot OwnerMascot;
	private Veterinarian Veterinarian;
	private String drugdosage;
	private MedicalHistory MedicalHistory;
	public Order(long orderId, app.domain.models.Mascot mascot, app.domain.models.OwnerMascot ownerMascot,
			app.domain.models.Veterinarian veterinarian, String drugdosage,
			app.domain.models.MedicalHistory medicalHistory) {
		super();
		OrderId = orderId;
		Mascot = mascot;
		OwnerMascot = ownerMascot;
		Veterinarian = veterinarian;
		this.drugdosage = drugdosage;
		MedicalHistory = medicalHistory;
	}
	
}
