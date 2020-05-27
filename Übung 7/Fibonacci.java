import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Fibonacci {

    public static int a = 0;
    public static int b = 1;
    public static int indexCounter = 1; //zählt index fi

    public static void main(String[] args) {

        Scanner anzahl = new Scanner(System.in);
        int index = anzahl.nextInt();
        anzahl.close();
        System.out.println("Nachfolger rekusriv : " + fibonacciRekursiv(index));
        System.out.flush();
        System.out.println("Nachfolger iterativ : " + fibonacciIterativ(index));
        System.out.flush();
        System.out.println("Fibonacci formel : " +fibonacciFormel(index));
        System.out.flush();

    }

    public static long fibonacciRekursiv(int index) {
        int temp;   //hilfsvariable
        if(index >= indexCounter){  // läuft solange bis eingegebner index >= indexCounter ist
            temp = a + b;
            b = a;
            a = temp;
            indexCounter++;
            fibonacciRekursiv(index);
        }
        return a + b;   //gibt das nächste glied aus

    }

    public static long fibonacciIterativ(int index) {
        int a = 0;
        int b = 1;
        int temp;

        for(int i = 1; i <= index; i++) {    //bricht die schleife ab wenn entsprechender index erreicht wurde
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
