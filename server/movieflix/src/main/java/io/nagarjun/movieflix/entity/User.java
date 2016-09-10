package io.nagarjun.movieflix.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "User.findAll", query = "SELECT e from User e ORDER BY e.email"),
		@NamedQuery(name = "User.findByEmail", query = "SELECT e from User e where e.email=:pEmail")
})
public class User {

	@Id
	private String id;
	private String role;

	private String firstName;
	private String lastName;

	@Column(unique = true)
	private String email;

	public User() {
		id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
	this.role = role;
}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ",role="+ role +", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}
