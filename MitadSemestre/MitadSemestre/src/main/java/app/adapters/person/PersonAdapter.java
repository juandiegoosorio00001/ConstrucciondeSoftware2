package app.adapters.person;

import org.springframework.stereotype.Service;

import app.adapters.person.entity.PersonEntity;
import app.domain.models.Person;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ports.PersonPort;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PersonAdapter implements PersonPort {

	@Override
	public boolean existPerson(long document) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void savePerson(Person Person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person findByDocument(long document) {
		// TODO Auto-generated method stub
		return null;
	}
	private Person personAdapter(PersonEntity personEntity) {
		Person person= new Person();
		person.setPersonId(personEntity.getPersonId());
		person.setDocument(personEntity.getDocument());
		person.setName(personEntity.getName());
		person.setAge(personEntity.getAge());
                return person;
	}
	

	private PersonEntity personAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(person.getPersonId());
		personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setAge(person.getAge());
		return personEntity;
	}
}
