public class Wizard extends Human{
	private int intelligence = 8;
	private int health = 50;
	private static int count = 0;

	public Wizard(String name) {
		this.name = name;
		this.setHealth(health);
		this.setIntelligence(intelligence);
		count += 1;
	}
	public void heal(Human target) {
		int targetHealth = target.getHealth();
        targetHealth += this.intelligence;
        target.setHealth(targetHealth);
	}
	public void fireball(Human victim) {
        int victimHealth = victim.getHealth();
		victimHealth -= this.intelligence*3;
        victim.setHealth(victimHealth);
	}
	public static void howMany() {
		System.out.println("Total Wizards: "+count);
	}
	public void displayStats() {
		int health = this.getHealth();
		int strength = this.getStrength();
		int intelect = this.getIntelligence();
		int stealth = this.getStealth();
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}