package app.adapters.inputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.Utils.PersonValidator;
import app.Utils.UserValidator;
import app.Utils.Utils;
import app.domain.models.Pet;
import app.domain.models.User;
import app.domain.services.AdminService;
import app.domain.services.PetService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Component
@NoArgsConstructor
public class AdminInput implements InputPort{

@Setter
@Getter

	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private AdminService adminService;
	@Autowired
    private PetService petService;

	private final String MENU = "Ingrese la opcion:" + " \n 1. para crear dueño de mascota.";

	public void menu() {
		boolean sesion = true;
		while (sesion) {
			sesion = options();
		}
	}
	
	private boolean options() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			switch (option) {
			case "1": {
					this.createOwner();
					this.createPet();
					return true;
			}
			case "2" :{
				System.out.println("Se ha cerrado sesion");
				return false;
			}
			default:
				System.out.println("opcion no valida");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private void createOwner() throws Exception {
		System.out.println("Ingrese el nombre del dueño de la mascota:");
	    String name = personValidator.nameValidator(Utils.getReader().nextLine());
	    System.out.println("Ingrese el documento del dueño de la mascota:");
	    long document = personValidator.documentValidator(Utils.getReader().nextLine());
	    System.out.println("Ingrese la edad del dueño de la mascota:");
	    int age = (int) personValidator.ageValidator(Utils.getReader().nextLine());
	    System.out.println("Ingrese el nombre de usuario del dueño de la mascota:");
	    String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
	    System.out.println("Ingrese la contraseña del dueño de la mascota:");
	    String password = userValidator.passwordValidator(Utils.getReader().nextLine());
	    User user = new User();
	    user.setName(name);
	    user.setDocument(document);
	    user.setAge(age);
	    user.setUserName(userName);
	    user.setPassword(password);
	    user.setRole("dueño de mascota"); 
	    adminService.registerOwner(user);
	    System.out.println("El dueño de la mascota ha sido registrado exitosamente.");
	}
	private void createPet() throws Exception{
		System.out.println("Ingrese el nombre de la mascota:");
	    String petName = Utils.getReader().nextLine();
	    System.out.println("Ingrese la especie de la mascota (perro, gato, etc.):");
	    String species = Utils.getReader().nextLine();
	    System.out.println("Ingrese la raza de la mascota:");
	    String breed = Utils.getReader().nextLine();
	    System.out.println("Ingrese las características de la mascota (color, tamaño):");
	    String characteristics = Utils.getReader().nextLine();
	    System.out.println("Ingrese el peso de la mascota:");
	    double weight = Double.parseDouble(Utils.getReader().nextLine());
	    User user = new User();
	    Pet newPet = new Pet();
	    newPet.setPetName(petName);
	    newPet.setSpecies(species);
	    newPet.setBreed(breed);
	    newPet.setCharacteristics(characteristics);
	    newPet.setWeight(weight);
	    newPet.setUser(user); 
	    petService.registerPet(newPet);
		
	}
	private void createVeterinarian() throws Exception{
		
	}
	
}

