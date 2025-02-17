package app.domain.models;


public class Person {
	private long document;
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	private String name;
	public Person(long document, String name, int age, String role) {
		super();
		this.document = document;
		this.name = name;
		this.age = age;
		this.role = role;
	}
	private int age;
	private String role;
}
