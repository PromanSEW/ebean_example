package models;

import io.ebean.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fish extends Model {
	@Id
	public int id;
	@Column(nullable = false)
	public String name;

	public Fish(String name) {
		setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}
}
