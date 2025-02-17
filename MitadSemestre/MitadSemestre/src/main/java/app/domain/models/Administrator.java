package app.domain.models;

public class Administrator extends Person {
	private long cedulaAdmin;
	private String nameAdmin;
	private int ageAdmin;
	private String roleAdmin;
	private String userAdmin;
	private String passwordAdmin;
	public Administrator(long document, String name, int age, String role, long cedulaAdmin, String nameAdmin,
			int ageAdmin, String roleAdmin, String userAdmin, String passwordAdmin) {
		super(document, name, age, role);
		this.cedulaAdmin = cedulaAdmin;
		this.nameAdmin = nameAdmin;
		this.ageAdmin = ageAdmin;
		this.roleAdmin = roleAdmin;
		this.userAdmin = userAdmin;
		this.passwordAdmin = passwordAdmin;
	}
	
}
