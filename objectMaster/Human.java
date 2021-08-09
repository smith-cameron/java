public class Human {
	protected String name;
	private int health = 100;
	private int strength = 3;
	private int intelligence = 3;
	private int stealth = 3;

	public Human() {

	}
	public void attack(Human victim) {
		victim.health -= this.strength;
	}
	public int getHealth() {
		return health;
	}
	public int getStrength() {
		return strength;
	}
	public int getIntelligence() {
		return intelligence;
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
}