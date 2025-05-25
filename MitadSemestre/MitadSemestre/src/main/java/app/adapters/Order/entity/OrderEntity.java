package app.adapters.Order.entity;

import java.time.LocalDate;

import app.adapters.MedicalHistory.entity.MedicalHistoryEntity;
import app.adapters.person.entity.PersonEntity;
import app.adapters.pet.entity.PetEntity;
import app.adapters.user.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "orders") 
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private PersonEntity owner;
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private UserEntity veterinarian;
    @Column(name = "medication_name")
    private String medicationName;
    @Column(name = "medication_dosage")
    private String medicationDosage;
    @Column(name = "generation_date")
    private LocalDate generationDate;
    @OneToOne 
    @JoinColumn(name = "medical_history_id") 
    private MedicalHistoryEntity medicalHistory;
    @Column(name = "order_status")
    private String orderStatus;
    @Column(name = "cancellation_reason")
    private String cancellationReason;
    @Column(name = "cancellation_date")
    private LocalDate cancellationDate;
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public PetEntity getPet() {
		return pet;
	}
	public void setPet(PetEntity pet) {
		this.pet = pet;
	}
	public PersonEntity getOwner() {
		return owner;
	}
	public void setOwner(PersonEntity owner) {
		this.owner = owner;
	}
	public UserEntity getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(UserEntity veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getMedicationName() {
		return medicationName;
	}
	public void setMedicationName(String medicationName) {
		this.medicationName = medicationName;
	}
	public String getMedicationDosage() {
		return medicationDosage;
	}
	public void setMedicationDosage(String medicationDosage) {
		this.medicationDosage = medicationDosage;
	}
	public LocalDate getGenerationDate() {
		return generationDate;
	}
	public void setGenerationDate(LocalDate generationDate) {
		this.generationDate = generationDate;
	}
	public MedicalHistoryEntity getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(MedicalHistoryEntity medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getCancellationReason() {
		return cancellationReason;
	}
	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}
	public LocalDate getCancellationDate() {
		return cancellationDate;
	}
	public void setCancellationDate(LocalDate cancellationDate) {
		this.cancellationDate = cancellationDate;
	}
    

    // Futuras columnas para venta
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "seller_id")
    // private UserEntity seller;
    // @Column(name = "total_price")
    // private Double totalPrice;
    // @Column(name = "sale_date")
    // private LocalDate saleDate;
    
}
