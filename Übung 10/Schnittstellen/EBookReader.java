//@author maximilian raspe
public class EBookReader extends KioskInhalt implements  Elektronisch, Kaufbar {

    double preis = 0.25;
    double stromverbrauch = 0.25;
	
	//konstruktor für ebookreader
    public EBookReader(String name) {
        super(name);
    }

    @Override
    public double getStromverbrauch() {
        return stromverbrauch;
    }

    @Override
    public void setPreis(double preis) {
        this.preis = preis;
    }

    @Override
    public double getPreis() {
        return preis;
    }
}
