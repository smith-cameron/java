package zooKeeper.controllers;

import zooKeeper.models.Mammal;
import zooKeeper.models.Gorilla;
import zooKeeper.models.Bat;

public class MainController {

	public static void main(String[] args) {
		Mammal tarzan = new Mammal("Tarzan");
		tarzan.displayEnergy();
        Gorilla kingKong = new Gorilla("King Kong");
		kingKong.throwSomething();
		kingKong.throwSomething();
		kingKong.throwSomething();
		kingKong.eatBananas();
		kingKong.eatBananas();
		kingKong.climb();
		kingKong.displayEnergy();
        Bat smaug = new Bat("Smaug");
		smaug.fly();
		smaug.attackTown();
		smaug.fly();
		smaug.attackTown();
		smaug.eatHumans();
		smaug.fly();
		smaug.attackTown();
		smaug.displayEnergy();
    }
}
