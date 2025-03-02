package Ports;

import app.domain.models.Person;

public interface PersonPort {
	public boolean existPerson(long document);
    public void savePerson(Person person);
    public Person findByDocument(long document);
}
