package app.adapters.inputs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.Utils.UserValidator;
import app.Utils.Utils;
import app.domain.models.User;
import app.domain.services.LoginService;
import app.ports.InputPort;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Component
public class LoginInput implements InputPort {
    private Map<String, InputPort> inputs;
    
    @Autowired
    private AdminInput adminInput; 
    
    @Autowired
    private UserValidator userValidator; 
    
    @Autowired
    private LoginService loginService; 
    
    private final String MENU = "Ingrese la opcion que desea:\n 1. iniciar sesion \n 2. salir";

   
    public LoginInput() {
        this.inputs = new HashMap<String, InputPort>();
    }

    @PostConstruct
    public void init() {
        inputs.put("admin", adminInput);
    }

    @Override
    public void menu() throws Exception {
        boolean sesion = true;
        for (; sesion;) {
            sesion = options();
        }
    }

    private boolean options() throws Exception {
        try {
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            switch (option) {
                case "1": {
                    this.login();
                    return true;
                }
                case "2": {
                    System.out.println("Hasta una proxima ocasión");
                    return false;
                }
                default: {
                    System.out.println("Ha elegido una opción inválida");
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }

    private void login() {
        try {
            System.out.println("Ingrese su usuario");
            String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
            System.out.println("Ingrese su contraseña");
            String password = userValidator.passwordValidator(Utils.getReader().nextLine());
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user = loginService.login(user);
            InputPort inputPort = inputs.get(user.getRole());
            inputPort.menu();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
