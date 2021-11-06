public class Human {
	protected String name;
	private int health = 100;
	private int strength = 3;
	private int intelligence = 3;
	private int stealth = 3;
	protected boolean isLiving = true;
	private static int humanCount = 0;
// Constructors -----------------------------
	public Human() {
		humanCount += 1;
	}
	// public Human(String name) {
	// 	this.name = name;
	// }
// Methods ----------------------------------
	public void attack(Human target) {
		if(this.lifeCheck()){
			if(target.lifeCheck()){
				target.health -= this.strength;
			}
			else{
				System.out.println(this.name+"... stop attacking that, it is dead.");
			}
		}
		else{
			System.out.println("Your Dead, stop trying.");
		}
	}
	public boolean lifeCheck(){
		if(this.health <= 0){
			this.isLiving = false;
			return this.isLiving;
		}
		return true;
	}
	public void displayHealth() {
		if(this.lifeCheck()){
			System.out.println(this.name+"'s health: "+this.health);
		}
		else{
			System.out.println(this.name+"'s Dead");
		}
	}
	public static void howMany() {
		System.out.println("Total Humans: "+humanCount);
	}
// Getters & Setters ------------------------
	public int getHealth() {
		return this.health;
	}
	public int getStrength() {
		return this.strength;
	}
	public int getIntelligence() {
		return this.intelligence;
	}
	public int getStealth() {
		return stealth;
	}
    public void setStealth(int adjValue){
        this.stealth = adjValue;
    }
    public void setHealth(int adjValue){
        this.health = adjValue;
    }
    public void setStrength(int adjValue){
        this.strength = adjValue;
    }
    public void setIntelligence(int adjValue){
        this.intelligence = adjValue;
    }
	public String getName() {
		return this.name;
	}
    public void setName(String name){
        this.name = name;
    }
	public boolean getLifeStatus() {
		return this.isLiving;
	}
    public void setLifeStatus(boolean status){
        this.isLiving = status;
    }

}