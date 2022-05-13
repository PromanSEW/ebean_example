package models;

import io.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fishes")
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
