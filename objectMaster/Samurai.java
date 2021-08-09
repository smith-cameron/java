public class Samurai extends Human{
	private int health = 200;
	private static int count = 0;

	public Samurai(String name) {
		this.name = name;
		this.setHealth(health);
		count += 1;
	}
	public void deathBlow(Human victim) {
		victim.setHealth(0);
		int myHealth = this.getHealth();
		myHealth /= 2;
        this.setHealth(myHealth);
	}
	public void meditate() {
        int myHealth = this.getHealth();
        myHealth += myHealth/2;
		this.setHealth(myHealth);
	}
	public static void howMany() {
		System.out.println("Total Samurai: "+count);
	}
	public void displayStats() {
		int health = this.getHealth();
		int strength = this.getStrength();
		int intelect = this.getIntelligence();
		int stealth = this.getStealth();
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}