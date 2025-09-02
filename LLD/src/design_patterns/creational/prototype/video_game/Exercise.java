package design_patterns.creational.prototype.video_game;

import java.util.Scanner;

public class Exercise {

	// Do not modify the run method. It is designed to gather user input and manage
	// character states.
	public void run() {

		Scanner sc = new Scanner(System.in);

		String warriorName = sc.nextLine();

		int health = sc.nextInt();

		int attackPower = sc.nextInt();

		int defense = sc.nextInt();

		Warrior warrior = new Warrior(warriorName, health, attackPower, defense);

		// TODO: Clone the original warrior character to create a new instance.
		Warrior clonedWarrior = warrior.clone();

		int clonedHealth = sc.nextInt();

		int clonedAttackPower = sc.nextInt();

		int clonedDefense = sc.nextInt();

		clonedWarrior.setHealth(clonedHealth);
		clonedWarrior.setAttackPower(clonedAttackPower);
		clonedWarrior.setDefense(clonedDefense);

		System.out.println("Original Character:");

		// TODO: Display the original warrior's attributes
		warrior.displayAttributes();

		System.out.println("Cloned Character:");

		// TODO: Display the cloned warrior's attributes
		clonedWarrior.displayAttributes();

		sc.close();
	}
}
