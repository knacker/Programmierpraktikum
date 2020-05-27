//@author maximilian raspe
public class Eintrag {

    private String produktname;
    private int menge;
    private double preis;
    private static double gesamtpreis;

	//gibt gesamtpreis zurück
    public double getGesamtpreis() {
        return gesamtpreis;
    }
	//Konstruktor für den artikel
    public Eintrag(String produktname, int menge, double preis) {
        this.produktname = produktname;
        this.menge = menge;
        this.preis = preis;
        gesamtpreis += preis;
    }

    public String getProduktname() {
        return produktname;
    }

    public int getMenge() {
        return menge;
    }

    public double getPreis() {
        return preis;
    }

    public String toString() {
        return this.produktname + " " + this.menge + " " + this.preis;
    }
}
