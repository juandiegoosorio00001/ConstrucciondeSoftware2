package app.domain.models;

public class Veterinarian extends Person{
	private long cedulaVeterinarian;
	private String nameVeterinarian;
	private int ageVeterinarian;
	private String roleVeterinarian;
	public Veterinarian(long document, String name, int age, String role, long cedulaVeterinarian,
			String nameVeterinarian, int ageVeterinarian, String roleVeterinarian) {
		super(document, name, age, role);
		this.cedulaVeterinarian = cedulaVeterinarian;
		this.nameVeterinarian = nameVeterinarian;
		this.ageVeterinarian = ageVeterinarian;
		this.roleVeterinarian = roleVeterinarian;
	}
}