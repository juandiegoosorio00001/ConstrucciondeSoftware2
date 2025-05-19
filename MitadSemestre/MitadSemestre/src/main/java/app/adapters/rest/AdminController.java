package app.adapters.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.adapters.rest.request.PetRequest;
import app.adapters.rest.request.UserRequest;
import app.domain.models.Person;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.services.AdminService;
import app.domain.services.PetService;
import app.exceptions.BussinesException;
import app.exceptions.InputsException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@RestController
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private PetService petService;

	@GetMapping("/")
	public String estaVivo() {
		return "estoy vivo";
	}
	
 	@PostMapping("/user/veterinarian")
 	
	public ResponseEntity createVeterinarian(@RequestBody UserRequest request){
 	try{
 		 System.out.println(request.toString());
 		 User user = new User();
 		 user.setName(request.getName());
 		 user.setUserName(request.getUserName());
 		 user.setPassword(request.getPassword());
 		 user.setDocument(request.getDocument());
 		 user.setAge(request.getAge());
 		 adminService.registerVeterinarian(user);
 		return new ResponseEntity("se ha creado el Veterinario",HttpStatus.OK);
	}catch(BussinesException be) {
		return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
	}catch(InputsException ie) {
		return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}	
 }
 	
@PostMapping("/user/seller")
 	
	public ResponseEntity createSeller(@RequestBody UserRequest request){
 	try{
 		 System.out.println(request.toString());
 		 User user = new User();
 		 user.setName(request.getName());
 		 user.setUserName(request.getUserName());
 		 user.setPassword(request.getPassword());
 		 user.setDocument(request.getDocument());
 		 user.setAge(request.getAge());
 		 adminService.registerSeller(user);
 		return new ResponseEntity("se ha creado el Vendedor",HttpStatus.OK);
	}catch(BussinesException be) {
		return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
	}catch(InputsException ie) {
		return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
@PostMapping("/user/owner")
	
public ResponseEntity createOwner(@RequestBody UserRequest request){
	try{
		 System.out.println(request.toString());
		 User user = new User();
		 user.setName(request.getName());
		 user.setUserName(request.getUserName());
		 user.setPassword(request.getPassword());
		 user.setDocument(request.getDocument());
		 user.setAge(request.getAge());
		 adminService.registerOwner(user);
		 return new ResponseEntity("se ha creado el Dueño",HttpStatus.OK);
	}catch(BussinesException be) {
		return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
	}catch(InputsException ie) {
		return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
public ResponseEntity registerPet(@RequestBody PetRequest request) {
    try {
        Pet pet = new Pet();
        pet.setPetName(request.getPetName());
        pet.setAgePet(request.getAgePet());
        pet.setBreed(request.getBreed());
        pet.setCharacteristics(request.getCharacteristics());
        pet.setDateCreated(request.getDateCreated());
        pet.setSpecies(request.getSpecies());
        pet.setWeight(request.getWeight());
        Person person = new Person();
        /*pet.setPerson(Owner);  Falta esta linea preguntar como puedo asignar el documento del dueño a la mascota*/
        petService.registerPet(pet);
        return new ResponseEntity("se ha creado la mascota",HttpStatus.OK);
	}catch(BussinesException be) {
		return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
	}catch(InputsException ie) {
		return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
	}catch(Exception e) {
		return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
	/*@GetMapping("/user")
	public ResponseEntity getUsers() {
		  List<User> users = adminService.getUsers();
		 List<UserResponse> response = adapter(users);
		 return new ResponseEntity(users,HttpStatus.OK);
		}catch(BussinesException be) {
			return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
		}
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}

