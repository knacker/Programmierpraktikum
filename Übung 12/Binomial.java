//@author maximilian raspe
public class Binomial {

    public static void main(String[] args) {
        binomialFakultat(8, 4);
        binomialProduktQuotient(8, 4);
        binomialAlternierend(8,4);
        binomialrekursiv(8, 4);

    }
    //vorteile: ist am übersichtlichsten da es die berechnungen trennt
    //nachteile:benötigt 2 methoden für eine relativ einfache rechnung, fak hat hohen speicherbedarf da rekursiv
    private static long binomialFakultat (int n, int k) {
        long ergebnis;
        ergebnis = fak(n) / (fak(k) * fak(n - k));
        return ergebnis;
    }
    private static long fak(int f) {
        long ergebnis = 0;
        if(f == 1) {
            return 1;
        }
        if(f == 2) {
            return 2;
        }
        if(f > 2) {
            ergebnis = f * fak(f - 1);
            return ergebnis;
        }
        return ergebnis;
    }
    /*
    Vorteile : einfach zu verstehen
    Nachteile : unübersichtlicher da sich nicht alles in eine schleife schreiben lässt
     */
    private static long binomialProduktQuotient(int n, int k) {

        int zaehler = 1;
        long nenner;

        for(int i = n; i > n - k + 1; i--) {
            zaehler *= i;
        }
        zaehler = zaehler * (n - k + 1);
        nenner = fak(k);
        long ergebnis =  zaehler / nenner;

        return ergebnis;
    }
    /*
    vorteile: ist relativ einfach zu lesen
    nachteile: benötgt double da sonst rundungsfehler auftreten die das ergebnis verälschen
     */
    private static long binomialAlternierend(int n, int k) {
        double zaehler = 1;
        double nenner = 1;
        long ergebnis = 1;
        int hilfsvariable = 1;

        for(int i = n; i >= n - k + 1; i--) {
            zaehler = i;
            nenner = hilfsvariable;
            ergebnis *= zaehler / nenner;
            hilfsvariable++;
        }
        return ergebnis;
    }
    /*
    vorteile : einfach zu verstehen, weniger quellcode
    nachteile :hoher rechenaufwand und speicherbedarf
     */
    private static long binomialrekursiv(int n, int k) {
        long ergebnis;
        if(k == 0) {
            return 1;
        }
        else if(n == 0) {
            return 0;
        }
        else {
            return binomialrekursiv(n - 1, k - 1) + binomialrekursiv(n - 1, k);
        }
    }
}
