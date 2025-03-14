package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import inputs.AdminInput;

@SpringBootApplication
public class VeterinariaApplication {
	@Autowired
	private AdminInput adminInput;

	public static void main(String[] args) {
		SpringApplication.run(VeterinariaApplication.class, args);
		
	}
	public void run(String... args) throws Exception {
        adminInput.menu();
    }

}
