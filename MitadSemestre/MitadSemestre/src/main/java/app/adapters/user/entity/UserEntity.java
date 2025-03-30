package app.adapters.user.entity;

import app.adapters.person.entity.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@NoArgsConstructor
public class UserEntity {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;
	@JoinColumn(name="personid")
	@OneToOne
	private PersonEntity person;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private String role;
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public PersonEntity getPerson() {
		return person;
	}
	public void setPerson(PersonEntity person) {
		this.person = person;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
