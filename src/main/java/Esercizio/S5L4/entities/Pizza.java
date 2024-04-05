package Esercizio.S5L4.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Setter
public class Pizza extends Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;

	@ManyToMany(mappedBy = "pizzas")
	private List<Topping> toppings;


	private List<Topping> toppingList;
	private boolean isXl = false;

	public Pizza(String name, List<Topping> toppingList, boolean isXl) {
		super(700, 4.3);
		this.name = name;
		this.toppingList = toppingList;
		this.isXl = isXl;
	}

	@Override
	public int getCalories() {
		return super.getCalories() + this.getToppingList().stream().mapToInt(Topping::getCalories).sum();
	}

	@Override
	public double getPrice() {
		return super.getPrice() + this.getToppingList().stream().mapToDouble(Topping::getPrice).sum();
	}

	@Override
	public String toString() {
		return "Pizza{" +
				"name='" + name + '\'' +
				", calories=" + calories +
				", price=" + price +
				", toppingList=" + toppingList +
				", isXl=" + isXl +
				'}';
	}
}
