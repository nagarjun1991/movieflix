package io.nagarjun.movieflix.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "Cast.findAll", query = "SELECT e from Cast e ORDER BY e.name"),
	@NamedQuery(name = "Cast.findByName", query = "SELECT e from Cast e where e.Cast=:pName")
})
public class Cast {
	
	@Id
	private String id;
	
	public Cast() {
		id = UUID.randomUUID().toString();
	}
	
	private String role;
	
	private String name;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
