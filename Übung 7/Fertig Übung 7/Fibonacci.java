import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Fibonacci {

    public static long a = 0;
    public static long b = 1;
    public static int indexCounter = 1; //zählt index fi für rekursiv

    public static void main(String[] args) {

        Scanner anzahl = new Scanner(System.in);
        System.out.println("länge eingeben");
        int index = anzahl.nextInt();
        anzahl.close();


        System.out.println("Nachfolger rekursiv : " + fibonacciRekursiv(index));    //Zeit: 0.02068845 ms für anzahl 5
        System.out.flush();
        System.out.println("Nachfolger iterativ : " + fibonacciIterativ(index));    //4.7013E-4 ms für anzahl 5
        System.out.flush();
        System.out.println("Fibonacci formel : " +fibonacciFormel(index));  // 2.73465E-4 ms für anzahl 5
        System.out.flush();
        /* 1.5
        Vorteile Rekursiv: -einfacher zu verstehen und sieht besser aus; ist einfacher zu programmieren als iterativ;
        Nachteile Rekursiv:- wird mit steigender zahl immer speicherintensiver

        Vorteile Iterativ: -eine optimierte iterative lösung ist schneller als rekursiv mit steigender zahl
        Nachteile Iterativ: -ist schwerer zu verstehen bzw unleserlicher

        Vorteile Formel:-liefert schnelle ergbnisse mit geringem speicher verbrauch
        Nachteile Formel:- es kommen rundungsfehler zustande
         */
    }

    public static long fibonacciRekursiv(int index) {
        long temp;   //hilfsvariable
        if(index > indexCounter){  // läuft solange bis eingegebner index > indexCounter ist
            temp = a + b;
            b = a;
            a = temp;
            indexCounter++;
            fibonacciRekursiv(index);
        }
        return a + b;   //gibt das glied an i-ter stelle aus

    }

    public static long fibonacciIterativ(int index) {
        long a = 0;
        long b = 1;
        long temp;

        for(int i = 1; i < index; i++) {    //bricht die schleife ab wenn entsprechender index erreicht wurde
            temp = a + b;
            b = a;
            a = temp;
        }
        return a + b;   //gibt folgeglied aus
    }

    public static long fibonacciFormel(int index) {
        double ergebnis = (1 / sqrt(5)) * ((Math.pow(((1 + sqrt(5)) / 2), index)) - (Math.pow(((1 - sqrt(5)) / 2), index)));    //berechnet fibonacci zahl für eingegeben index
        return (long)ergebnis;
    }
}
