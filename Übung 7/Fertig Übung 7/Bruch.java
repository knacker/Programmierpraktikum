//@author Maximiian Raspe
public class Bruch {
    //4.1
    private int zaehler;
    private int nenner;


    public int getNenner() {    //getter method
        return this.nenner;
    }

    public int getZaehler() {   //getter method
        return this.zaehler;
    }
    //4.2
    public Bruch(int zaehler, int nenner) { //konstruktor

        if (nenner == 0) {
            System.out.println("Nenner ungleich 0 bitte");
            System.exit(-1);    //beendet programm mit fehlermeldung
        } else {
            this.zaehler = zaehler;
            this.nenner = nenner;
        }

    }

    public Bruch(int ganzzahl) {    //bruch für ganzzahl

        this(ganzzahl, 1);
    }

    public String toString() {  //@override toString
        return this.zaehler + " / " + this.nenner;
    }

    //4.4   //grundrechenarten für brüche
    public static Bruch Multiplizieren(Bruch bruch1, Bruch bruch2) {
        int zaehler = bruch1.getZaehler() * bruch2.getZaehler();
        int nenner = bruch1.getNenner() * bruch2.getNenner();
        return new Bruch(zaehler, nenner);
    }
    public static Bruch Dividieren(Bruch bruch1, Bruch bruch2) {
        int zaehler = bruch1.getZaehler() * bruch2.getNenner();
        int nenner = bruch1.getNenner() * bruch2.getZaehler();
        return new Bruch(zaehler, nenner);
    }
    public static Bruch Addieren(Bruch bruch1, Bruch bruch2) {
        int zaehler = bruch1.getZaehler() * bruch2.getNenner() + bruch2.getZaehler() * bruch1.getNenner();
        int nenner = bruch1.getNenner() * bruch2.getNenner();
        return new Bruch(zaehler, nenner);
    }
    public static Bruch Subtrahieren(Bruch bruch1, Bruch bruch2) {
        int zaehler = bruch1.getZaehler() * bruch2.getNenner() - bruch2.getZaehler() * bruch1.getNenner();
        int nenner = bruch1.getNenner() * bruch2.getNenner();
        return new Bruch(zaehler, nenner);
    }

    //4.5
    public void kuerzeBruch() {

        zaehler = getZaehler();
        nenner = getNenner();

        for(int i = 1; i <= zaehler && i <= nenner; i++) {  //findet den größten teiler und kürzt dementsprechened den bruch
            if(zaehler % i == 0 && nenner % i == 0) {
                zaehler = zaehler / i;
                nenner = nenner / i;
            }
        }
        new Bruch(zaehler, nenner); //setzt den neuen gekürzten bruch
    }
    public void dezimalBruch() {
        int zaehler = getZaehler();
        int nenner = getNenner();

        double dezimal = (double)zaehler / (double)nenner;  //berechnet den dezimal wert des bruchs
        System.out.println("Dezimalwert : " + dezimal);
    }
}
