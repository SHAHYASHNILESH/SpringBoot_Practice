package design_patterns.creational.prototype.video_game;

public class Mage implements Character {

	private String name;
	private int health;
	private int attackPower;
	private int defense;

	public Mage(String name, int health, int attackPower, int defense) {
		this.name = name;
		this.health = health;
		this.attackPower = attackPower;
		this.defense = defense;
	}

	@Override
	public Mage clone() {
		// TODO: Return a new Mage instance with the given set of attributes.
		return new Mage(this.name, this.health, this.attackPower, this.defense);
	}

	@Override
	public void displayAttributes() {
		System.out.println("Mage - Name: " + name + ", Health: " + health + ", Attack Power: " + attackPower
				+ ", Defense: " + defense);
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public int getDefense() {
		return defense;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
