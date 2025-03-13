package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	private long OrderId;
	private Mascot Mascot;
	private String drugdosage;
	private MedicalHistory MedicalHistory;
	
}
