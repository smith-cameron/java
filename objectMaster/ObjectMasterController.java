public class ObjectMasterController {

	public static void main(String[] args) {
		// Ninja kalem = new Ninja("kalem");
		Wizard quickBen = new Wizard("quickBen");
		Wizard tattersail = new Wizard("tattersail");
		// Samurai fiddler = new Samurai("fiddler");
		// Ninja cotillion = new Ninja("cotillion");
		// Samurai stormy = new Samurai("stormy");
		// Samurai gesler = new Samurai("gesler");
		// Samurai kindly = new Samurai("kindly");
		// Samurai hedge = new Samurai("hedge");
		// Wizard icarium = new Wizard("icarium");
		// Ninja sorry = new Ninja("sorry");
		// kindly.deathBlow(kalem);
		quickBen.displayHealth();
		tattersail.displayHealth();
		// kalem.displayHealth();
		// kalem.steal(stormy);
		// kalem.steal(stormy);
		// kalem.steal(stormy);
		// kalem.avoid();
		// kalem.displayHealth();
		// stormy.displayHealth();
		quickBen.fireball(tattersail);
		quickBen.fireball(tattersail);
		// tattersail.fireball(gesler);
		// tattersail.fireball(gesler);
		// tattersail.fireball(gesler);
		// gesler.displayHealth();
		// gesler.meditate();
		// gesler.displayHealth();
		// sorry.attack(icarium);
		// sorry.attack(icarium);
		quickBen.attack(tattersail);
		tattersail.displayHealth();
		quickBen.fireball(tattersail);
		// gesler.displayHealth();
		// cotillion.displayHealth();
		// icarium.heal(cotillion);
		// hedge.deathBlow(sorry);
		// sorry.displayHealth();
		// tattersail.heal(sorry);
		// tattersail.heal(sorry);
		// tattersail.heal(sorry);
		// tattersail.heal(sorry);
		// sorry.displayHealth();
		// tattersail.displayHealth();
		// cotillion.displayHealth();
		// icarium.displayHealth();
		// fiddler.displayStats();
		// Samurai.howMany();
		// Ninja.howMany();
		Wizard.howMany();
		Human.howMany();

	}

}