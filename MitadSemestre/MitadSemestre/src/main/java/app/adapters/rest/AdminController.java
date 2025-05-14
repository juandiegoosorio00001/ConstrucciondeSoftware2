package app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.adapters.rest.request.UserRequest;
import app.domain.models.User;
import app.domain.services.AdminService;
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

	@GetMapping("/")
	public String estaVivo() {
		return "estoy vivo";
	}
 	@PostMapping("/user")
	public String creatUser(@RequestBody UserRequest request) throws Exception {
 		User user = new User();
 		user.setName(request.getName());
 		user.setUserName(request.getUserName());
 		user.setPassword(request.getPassword());
 		user.setDocument(request.getDocument());
 		user.setAge(request.getAge());
 		adminService.registerVeterinarian(user);
 		return "veterinario Creado";
 	}	
}
