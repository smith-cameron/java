public class Ninja extends Human{
	private int stealth = 10;
	private static int count = 0;

	public Ninja(String name) {
		this.name = name;
		this.setStealth(stealth);
		count += 1;
	}
	public void steal(Human victim) {
        int myHealth = this.getHealth();
        int victimHealth = victim.getHealth();
		victimHealth -= this.stealth;
		myHealth += this.stealth;
        this.setHealth(myHealth);
        victim.setHealth(victimHealth);
	}
	public void avoid() {
        int myhealth = this.getHealth();
		myhealth -= 10;
        this.setHealth(myhealth);
	}
	public static void howMany() {
		System.out.println("Total Ninjas: "+count);
	}
	public void displayStats() {
		int health = this.getHealth();
		int strength = this.getStrength();
		int intelect = this.getIntelligence();
		int stealth = this.getStealth();
		System.out.println(this.name+"'s Reamaining-> Health: "+health+" Strength: "+strength+" Intelect: "+intelect+" Stealth: "+stealth);
	}
}