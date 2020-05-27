//@author maximilian raspe
import java.util.Scanner;
public class Wochentag {

    public static void main(String[] args){

        String wochentag;
        Scanner scan = new Scanner(System.in);
        //datum einlesen
        System.out.println("Geben sie den Tag ein");
        int tag = scan.nextInt();
        System.out.println("Geben sie den Monat ein");
        int monat = scan.nextInt();
        System.out.println("Geben sie das Jahr ein");
        int jahr = scan.nextInt();

        scan.close();
        //gibt ersten beiden ziffern zurück
        int c = Integer.parseInt(("" + jahr).substring(0, 2));

        if(monat == 1 && jahr % 100 == 0 || monat == 2 && jahr % 100 == 0) {
            c = c - 1;
        }

        if(monat == 1 || monat == 2) {
            jahr = jahr - 1;
            jahr = Integer.parseInt(("" + jahr).substring(2));
        //gibt letzten beiden ziffern zurück
        } else jahr = Integer.parseInt(("" + jahr).substring(2));
       //monate laut julianischer zählung
        switch(monat) {
            case 1 : monat = 11;
            break;
            case 2 : monat = 12;
                break;
            case 3 : monat = 1;
                break;
            case 4 : monat = 2;
                break;
            case 5 : monat = 3;
                break;
            case 6 : monat = 4;
                break;
            case 7 : monat = 5;
                break;
            case 8 : monat = 6;
                break;
            case 9 : monat = 7;
                break;
            case 10 : monat = 8;
                break;
            case 11 : monat = 9;
                break;
            case 12 : monat = 10;
                break;
        }

        double w = (tag + (2.6 * monat - 0.2) + jahr + (jahr / 4) + (c / 4) - 2 * c) % 7 ;
        int ergebnis = (int)Math.floor(w);
        ergebnis = ergebnis % 7;
        //berechnung falls ergebnis negativ ist
        if(ergebnis < 0) {
            ergebnis = Math.floorDiv(ergebnis, 7);
        }
        //berechnung des wochentages, negative cases falls negatives ergebnis
        switch(ergebnis) {
            case 0: wochentag = "Sonntag";
                break;
            case 1: wochentag = "Montag";
                break;
            case 2: wochentag = "Dienstag";
                break;
            case 3: wochentag = "Mittwoch";
                 break;
            case 4: wochentag = "Donnerstag";
                break;
            case 5: wochentag = "Freitag";
                break;
            case 6: wochentag = "Samstag";
                break;
            case -1: wochentag = "Montag";
                break;
            case -2: wochentag = "Dienstag";
                break;
            case -3: wochentag = "Mittwoch";
                break;
            case -4: wochentag = "Donnerstag";
                break;
            case -5: wochentag = "Freitag";
                break;
            case -6: wochentag = "Samstag";
                break;
            default : wochentag = "Irgendwas war falsch";
                break;
        }
        System.out.println(wochentag);
    }
}
