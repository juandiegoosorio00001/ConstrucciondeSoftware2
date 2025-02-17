package app.domain.models;

public class Seller extends Person {
	private long cedulaSeller;
	private String nameSeller;
	private int ageSeller;
	private String roleSeller;
	public Seller(long document, String name, int age, String role, long cedulaSeller, String nameSeller, int ageSeller,
			String roleSeller) {
		super(document, name, age, role);
		this.cedulaSeller = cedulaSeller;
		this.nameSeller = nameSeller;
		this.ageSeller = ageSeller;
		this.roleSeller = roleSeller;
	}
	
}
