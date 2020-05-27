//@author maximilian raspe
public class Zeitung extends KioskInhalt implements Kaufbar {

    private double preis = 0.5;
	//konstruktor für die zeitung
    public Zeitung(String name) {
        super(name);
    }
    @Override
    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public double getPreis() {
        return this.preis;
    }
}
