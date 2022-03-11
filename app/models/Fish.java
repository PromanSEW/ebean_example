package models;

import io.ebean.Finder;
import io.ebean.Model;

import javax.annotation.Nonnull;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "fishes")
public class Fish extends Model {

	private static final Finder<Integer, Fish> finder = new Finder<>(Fish.class);

	@Id
	public int id;
	@Column(nullable = false)
	public String name;

	public Fish(String name) {
		this.name = name;
	}

	private void setName(String name) {
		this.name = name;
	}

	/** Все рыбы */
	@Nonnull
	public static List<Fish> all() {
		return finder.query().orderById(true).findList();
	}

	public static Fish byId(int id) {
		return finder.byId(id);
	}

	/** @return Отсортировнный по имени список рыб */
	@Nonnull
	public static List<Fish> sorted() {
		return finder.query().order("name").findList();
	}

	public static boolean update(int id, String name) {
		Fish fish = Fish.byId(id);
		if (fish == null) return false;
		fish.setName(name);
		fish.update();
		return true;
	}

	/** Добавить рыб при установке сервера */
	public static void addFishes(@Nonnull List<String> fishes) {
		for (String fish : fishes) {
			new Fish(fish).save();
		}
	}
}
