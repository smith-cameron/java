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
		if(this.lifeCheck()){
			int targetHealth = target.getHealth();
			if(target.lifeCheck()){
				targetHealth += this.intelligence;
				target.setHealth(targetHealth);
			}
			else{
				System.out.println("You cannot heal that, it is dead.");
			}
		}
		else{
			System.out.println("Your Dead, stop trying.");
		}
	}
	public void fireball(Human target) {
		if(this.lifeCheck()){
			int targetHealth = target.getHealth();
			if(target.lifeCheck()){
				targetHealth -= this.intelligence*3;
				target.setHealth(targetHealth);
			}
			else{
				System.out.println("You cannot kill " +target.getName()+ " ,it is dead.");
			}
		}
		else{
			System.out.println("Your Dead, stop trying.");
		}
	}
	public static void howMany() {
		System.out.println("Total Wizards: "+count);
	}
	public void displayStats() {
		System.out.println(this.name+"'s Reamaining-> Health: "+this.getHealth()+" Strength: "+this.getStrength()+" Intelect: "+this.getIntelligence()+" Stealth: "+this.getStealth());
	}
}