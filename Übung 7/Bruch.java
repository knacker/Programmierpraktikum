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
            System.out.println(Integer.toString(getZaehler()) + " / " + Integer.toString(getNenner())); //4.3
        }
    }

    public Bruch(int ganzzahl) {    //bruch für ganzzahl
        this(ganzzahl, 1);
    }
    //4.4
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

        int zaehler = getZaehler();
        int nenner = getNenner();

        for(int i = 1; i <= zaehler && i <= nenner; i++) {  //findet den größten teiler und kürzt dementsprechened den bruch
            if(zaehler % i == 0 && nenner % i == 0) {
                zaehler = zaehler / i;
                nenner = nenner / i;
            }
        }
        System.out.println("Gekürzter Bruch : ");
        new Bruch(zaehler, nenner); //gibt den neuen gekürzten bruch aus
    }
    public void dezimalBruch() {
        int zaehler = getZaehler();
        int nenner = getNenner();

        double dezimal = (double)zaehler / (double)nenner;  //berechnet den dezimal wert des bruchs
        System.out.println("Dezimalwert : " + dezimal);
    }
}