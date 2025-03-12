package app.domain.models;

import java.time.LocalDate;

public class Mascot {
    private String mascotName;
    private long mascotId;
    private long ageMascot;
    private String species;
    private String breed;
    private String characteristics;
    private double weight;  
    private LocalDate dateCreated;
	public Mascot(String mascotName, long mascotId, long ageMascot, String species, String breed,
			String characteristics, double weight, LocalDate dateCreated) {
		super();
		this.mascotName = mascotName;
		this.mascotId = mascotId;
		this.ageMascot = ageMascot;
		this.species = species;
		this.breed = breed;
		this.characteristics = characteristics;
		this.weight = weight;
		this.dateCreated = dateCreated;
	}
	public String getMascotName() {
		return mascotName;
	}
	public void setMascotName(String mascotName) {
		this.mascotName = mascotName;
	}
	public long getMascotId() {
		return mascotId;
	}
	public void setMascotId(long mascotId) {
		this.mascotId = mascotId;
	}
	public long getAgeMascot() {
		return ageMascot;
	}
	public void setAgeMascot(long ageMascot) {
		this.ageMascot = ageMascot;
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
	
}