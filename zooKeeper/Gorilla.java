class Gorilla extends Mammal{
	private int defaultEnergyLevel = 200;


	// public Gorilla() {
	// 	this.setEnergyLevel(defaultEnergyLevel);
	// }

	public Gorilla(String name) {
		this.setEnergyLevel(defaultEnergyLevel);
		this.name = name;
	}

	public void throwSomething() {
		if(this.lifeCheck()){
			int eLev = this.getEnergyLevel();
			if(eLev >= 5){
				eLev -= 5;
				this.setEnergyLevel(eLev);
				System.out.println("Gorilla throws something. Energy now: "+eLev);
			}
			else{
				System.out.println("Eat bananas to gain some energy!");
			}
		}
		else{
			System.out.println("Your Dead");
		}
	}

	public void climb() {
		if(this.lifeCheck()){
			int eLev = this.getEnergyLevel();
			if(eLev >= 10){
				eLev -= 10;
				this.setEnergyLevel(eLev);
				System.out.println("Gorilla climbs a tree. Energy now: "+eLev);
			}
			else{
				System.out.println("Eat bananas to gain some energy!");
			}
		}
		else{
			System.out.println("Your Dead");
		}
	}

	public void eatBananas() {
		if(this.lifeCheck()){
			int eLev = this.getEnergyLevel();
			
			eLev += 10;
			this.setEnergyLevel(eLev);
			System.out.println("Gorilla eats a banana. Energy now: "+eLev);
		}
		else{
			System.out.println("Your Dead");
		}
	}
}