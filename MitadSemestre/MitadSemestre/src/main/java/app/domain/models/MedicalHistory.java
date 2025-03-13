package app.domain.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MedicalHistory {
    public Mascot mascot;
    public String reasonConsult;
    public String symptomatology;
    public String diagnosis;
    public String procedure;
    public String medication;
    public String medicationDosage;
    public String idOrder;
    public List<String> vaccinationRecord;
    public String allergyMedications;
    public String procedureDetail;
    public boolean orderCancellation;
 
}