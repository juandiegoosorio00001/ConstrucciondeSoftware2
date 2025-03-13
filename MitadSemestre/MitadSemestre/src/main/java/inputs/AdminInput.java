package inputs;

import org.antlr.v4.runtime.misc.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import ports.InputPort;
import services.AdminService;

public class AdminInput implements InputPort{
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
					this.createPartner();
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

	private void createPartner() throws Exception {
		System.out.println("ingrese el nombre del socio");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el documento del socio");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el numero celular del socio");
		long cellPhone = personValidator.cellPhoneValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el userName del socio");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese la contraseña socio");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());
		Partner partner = new Partner();
		partner.setDocument(document);
		partner.setName(name);
		partner.setCellPhone(cellPhone);
		partner.setUserName(userName);
		partner.setPassword(password);
		partner.setRole("partner");
		adminService.registerPartner(partner);
	}
}
}
