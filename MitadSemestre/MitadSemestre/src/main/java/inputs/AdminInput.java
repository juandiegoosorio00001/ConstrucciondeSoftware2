package inputs;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Utils.PersonValidator;
import Utils.UserValidator;
import Utils.Utils;
import app.domain.models.Mascot;
import app.domain.models.Person;
import app.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ports.InputPort;
import services.AdminService;
import services.PetService;
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

	private final String MENU = "Ingrese la opcion:" + " \n 1. para crear dueño de mascota." + " \n 2. ver facturas del club."
			+ " \n 3. ver facturas de un socio." + " \n 4. ver facturas de una persona." + " \n 5. promover socios."+ " \n 6. cerrar sesion.";

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
					return true;
			}
			case "6" :{
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
	    Mascot newMascot = new Mascot();
	    newMascot.setMascotName(petName);
	    newMascot.setSpecies(species);
	    newMascot.setBreed(breed);
	    newMascot.setCharacteristics(characteristics);
	    newMascot.setWeight(weight);
	    newMascot.setUser(user); 
	    petService.registerPet(newMascot);
	}
}

