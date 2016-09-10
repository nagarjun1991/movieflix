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
	@NamedQuery(name = "Genre.findAll", query = "SELECT e from Genre e ORDER BY e.kind"),
	@NamedQuery(name = "Genre.findByKind", query = "SELECT e from Genre e where e.Genre=:pKind")
})

public class Genre {
	 	
	@Id
	private String id;
	
	public Genre() {
		id = UUID.randomUUID().toString();
	}
	private String kind;
	 	
	public String getKind() {
		return kind;
	}
	 
	public void setKind(String kind) {
		this.kind = kind;
	}
	 
	public String getId() {
		return id;
	}
	 
	public void setId(String id) {
		this.id = id;
	}	
}