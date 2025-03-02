package app.domain.models;

public class Administrator extends Person {
	private String userAdmin;
    private String passwordAdmin;
	public Administrator(long document, String name, int age, String role) {
		super(document, name, age, role);
	}
	public String getUserAdmin() {
		return userAdmin;
	}
	public void setUserAdmin(String userAdmin) {
		this.userAdmin = userAdmin;
	}
	public String getPasswordAdmin() {
		return passwordAdmin;
	}
	public void setPasswordAdmin(String passwordAdmin) {
		this.passwordAdmin = passwordAdmin;
	}
    
}
