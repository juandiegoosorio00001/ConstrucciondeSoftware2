package app.adapters.pet.entity;

import java.sql.Date;

import app.adapters.person.entity.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class PetEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long petId;
	@JoinColumn(name="owner_id")
	@ManyToOne
	private PersonEntity person;
	@Column(name="pet_name")
	private String petName;
	@Column(name="pet_age")
	private long agePet;
	@Column(name="species")
	private String species;
	@Column(name="breed")
	private String breed;
	@Column(name="characteristics")
	private String characteristics;
	@Column(name="weight")
	private double weight;
	@Column(name="dateCreated")
	private Date dateCreated;
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
	}
	public PersonEntity getPerson() {
		return person;
	}
	public void setPerson(PersonEntity person) {
		this.person = person;
	}
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public long getAgePet() {
		return agePet;
	}
	public void setAgePet(long agePet) {
		this.agePet = agePet;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getCharacteristics() {
		return characteristics;
	}
	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
	
}
