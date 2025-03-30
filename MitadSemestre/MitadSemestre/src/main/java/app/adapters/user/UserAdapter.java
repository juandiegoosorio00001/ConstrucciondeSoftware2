package app.adapters.user;

import org.springframework.stereotype.Service;

import app.adapters.person.entity.PersonEntity;
import app.adapters.user.entity.UserEntity;
import app.adapters.user.repository.UserRepository;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;

@Service
public class UserAdapter implements UserPort {
	private UserRepository userRepository;
	@Override
	public boolean existUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		UserEntity userEntity = userEntityAdapter(user);
		userRepository.save(userEntity);
		user.setUserId(userEntity.getUserId());
	}

	private UserEntity userEntityAdapter(User user) {
		PersonEntity personEntity = personAdapter(user);
		UserEntity userEntity = new UserEntity();
		userEntity.setPerson(personEntity);
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setRole(user.getRole());
		return userEntity;
		
	}

	@Override
	public User findByUserName(User user) {
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		if (userEntity == null){
			return null;
		}
		return userAdapter(userEntity);
	}
	@Override
	public User findByPersonId(Person person) {
		PersonEntity personEntity = personAdapter(person);
		UserEntity userEntity = userRepository.findByPerson_PersonId(personEntity.getPersonId());
		User user = userAdapter(userEntity);
		return user;
	}
	private PersonEntity personAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(person.getPersonId());
		personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setAge(person.getAge());
		return personEntity;
	}
	private User userAdapter(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User user = new User();
		user.setPersonId(userEntity.getPerson().getPersonId());
		user.setDocument(userEntity.getPerson().getDocument());
		user.setName(userEntity.getPerson().getName());
		user.setAge(userEntity.getPerson().getAge());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setRole(userEntity.getRole());
		user.setUserId(userEntity.getUserId());
		return user;
		
	}
}
