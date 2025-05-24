package app.adapters.rest.request;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import app.domain.models.Person;
import app.domain.models.User;

public class PetRequest {
	 @JsonProperty("pet_name")
	private String petName;
    public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public long getPetId() {
		return petId;
	}
	public void setPetId(long petId) {
		this.petId = petId;
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
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public long getPerson() {
		return person;
	}
	public void setPerson(long person) {
		this.person = person;
	}
	private long petId;
	@JsonProperty("pet_age")
    private long agePet;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;  
    private LocalDate dateCreated;
    private long person;
}
