package app.ports;

import app.domain.models.Person;

public interface PersonPort {
	public boolean existPerson(long document);
	public void savePerson(Person Person);
	public Person findByDocument(long document);
}
