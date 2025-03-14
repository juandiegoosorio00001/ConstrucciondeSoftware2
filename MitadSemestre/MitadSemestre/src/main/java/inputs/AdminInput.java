package inputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Utils.PersonValidator;
import Utils.UserValidator;
import Utils.Utils;
import app.domain.models.Person;
import app.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ports.InputPort;
import services.AdminService;
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

	private final String MENU = "Ingrese la opcion:" + " \n 1. para crear Socios." + " \n 2. ver facturas del club."
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
		System.out.println("ingrese el nombre del dueño de la mascota");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el documento del dueño de la mascota");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el numero celular del dueño de la mascota");
		int age = (int) personValidator.ageValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el userName del dueño de la mascota");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese la contraseña dueño de la mascota");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());
		User user = new User(document, name, age, "owner", 0L, userName, password);

	    adminService.registerOwner(user);
	}
}

