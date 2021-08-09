public class Iphone extends Phone implements Ringable{

	public Iphone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
		super(versionNumber, batteryPercentage, carrier, ringTone);
	}

	@Override
    public String ring() {
        String ring = "The "+this.getVersionNumber()+" Ringtone: "+this.getRingTone();
		return ring;
    }
    @Override
    public String unlock() {
        String unlock = "The "+this.getVersionNumber()+" Unlocking via fingerprint scan";
    	return unlock;
    }
    @Override
    public void displayInfo() {
    	System.out.printf("The iPhone %s from %s\n", this.getVersionNumber(), this.getCarrier() );
    }
}