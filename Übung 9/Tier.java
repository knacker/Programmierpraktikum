//@author maximilian raspe
public abstract class Tier implements Schreiverhalten {
	
    protected Schreiverhalten schreiverhalten;
    protected String name;
    protected String art;

    public String getArt() {
        return art;
    }

    public String getName() {
        return name;
    }

    public Schreiverhalten getSchreiverhalten() {
        return schreiverhalten;
    }
	//führt schrei aus
    public void schreien() {
        schreiverhalten.schreien();
    }
	//gibt namen und art des tieres zurück
    public String toString() {
        return this.getName() + " der " + this.getArt();
    }
}
