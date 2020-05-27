//@author maximilian raspe
public class Kasse extends KioskInhalt implements Elektronisch {

    double stromverbrauch = 0.5;
	//konstruktor für klassennamen überschreibt
    public Kasse(String name) {
        super(name);
    }

    @Override
    public double getStromverbrauch() {
        return 0.5;
    }
}
