package zooKeeper.models;

public class Mammal {
	protected String name;
    protected int energyLevel = 50;
	protected boolean isLiving = true;

	public Mammal(String name) {
		this.name = name;
		System.out.println("New Mammal named "+name);
	}

	public Mammal() {
	}

	public int getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(int eLev) {
		this.energyLevel = eLev;
	}

	public void setLifeStatus(boolean status){
		this.isLiving = status;
	}

	public boolean getLifeStatus(){
		return this.isLiving;
	}

	public void displayEnergy() {
		if(this.lifeCheck()){
			System.out.println(this.name+"'s energy: "+this.energyLevel);
		}
		else{
			System.out.println(this.name+"'s Dead");
		}
	}

	public boolean lifeCheck(){
		if(this.energyLevel <= 0){
			this.isLiving = false;
			return this.isLiving;
		}
		return true;
	}
}
