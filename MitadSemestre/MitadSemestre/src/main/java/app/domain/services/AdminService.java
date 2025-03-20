package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.models.User;
import app.ports.PersonPort;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class AdminService {
	@Autowired
	private PersonPort personPort;
	@Autowired
	private UserPort userPort;

    public void registerVeterinarian(User user)throws Exception{
    	
        
        if (personPort.existPerson(user.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("ya existe ese nombre de usuario registrado");
        }
        user.setRole("veterinarian");
        personPort.savePerson(user);
        userPort.saveUser(user);
    }
    public void registerSeller(User user)throws Exception{
    	
        
        if (personPort.existPerson(user.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("ya existe ese nombre de usuario registrado");
        }
        user.setRole("Seller");
        personPort.savePerson(user);
        userPort.saveUser(user);
    }
    public void registerOwner(User user)throws Exception{
   
        if (personPort.existPerson(user.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
        }
        if (userPort.existUserName(user.getUserName())){
            throw new Exception("ya existe ese nombre de usuario registrado");
        }
        user.setRole("Owner");
        personPort.savePerson(user);
        userPort.saveUser(user);
    }
}
