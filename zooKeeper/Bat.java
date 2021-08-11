class Bat extends Mammal{
    private int defaultEnergyLevel = 300;

	// public Bat() {
	// 	this.energyLevel = defaultEnergyLevel;
	// }

	public Bat(String name) {
		this.energyLevel = defaultEnergyLevel;
		this.name = name;
	}

	public void fly() {
		if(this.lifeCheck()){
			if(this.energyLevel >= 50){
				this.energyLevel -= 50;
				System.out.println("Flap-Flap-Flap(Flying) Energy now: "+this.energyLevel);
			}
			else{
				System.out.println("Eat humans to gain some energy!");
			}
		}
		else{
			System.out.println("Your Dead");
		}
	}

	public void attackTown() {
		if(this.lifeCheck()){
			if(this.energyLevel >= 100){
				this.energyLevel -= 100;
				System.out.println("Snap-Crackle-Pop(Burning Things) Energy now: "+this.energyLevel);
			}
			else{
				System.out.println("Eat humans to gain some energy!");
			}
		}
		else{
			System.out.println("Your Dead");
		}
	}

	public void eatHumans() {
		if (this.lifeCheck()){
			this.energyLevel += 25;
			System.out.println("AHHHH-'Snap-Crack-Pop'(Eating Things) Energy now: "+this.energyLevel);
		}
		else{
			System.out.println("Your Dead");
		}
	}
}
