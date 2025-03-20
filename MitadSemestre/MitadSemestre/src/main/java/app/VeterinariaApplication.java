package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import app.inputs.LoginInput;

@SpringBootApplication
public class VeterinariaApplication implements CommandLineRunner {
    
    @Autowired
    private LoginInput loginInput; 

    @Override
    public void run(String... args) throws Exception {
        loginInput.menu();
    }

    public static void main(String[] args) {
        SpringApplication.run(VeterinariaApplication.class, args);
    }
}