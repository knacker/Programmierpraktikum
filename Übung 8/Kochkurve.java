//@author maximilian raspe
import java.util.Scanner;
public class Kochkurve {

    public static void main(String [] args) {
        Scanner stufe = new Scanner(System.in);
        System.out.println("Anzahl der Iterationen eingeben");
        int iterationen = stufe.nextInt();
        stufe.close();

        Turtle kochkurve = new Turtle(new LineFrame("Kochkurve"));

        double frameLaenge = 1.0;
        double kantenlaenge = 0.7; // Kanten länge.
        double hoehe = (kantenlaenge / 2) * Math.sqrt(3); // Höhe des Dreiecks.
        double x1 = frameLaenge / 2; // x- Koordinaten für die erste Ecke (Oben mitte).
        double y1 = (frameLaenge - hoehe) / 2; // y-Koordinaten für die erste Ecke (Oben mitte).

        // Bereite Startpunkt und Winkel der Turtle vor
        double dx = x1 - 0;
        double dy = y1 - 0;
        double startAngle = Math.atan(dy / dx);
        double help = Math.pow(dy, 2) + Math.pow(dx, 2);
        double startStepSize = Math.sqrt(help);

        kochkurve.turn(-startAngle);
        kochkurve.forward(startStepSize);
        kochkurve.turn(-((Math.PI / 6) + (Math.PI / 2) - startAngle));
        kochkurve.penDown();

        zeichnen(kochkurve,iterationen, kantenlaenge);
        kochkurve.turn(Math.PI / 1.5);
        zeichnen(kochkurve, iterationen, kantenlaenge);
        kochkurve.turn(Math.PI / 1.5);
        zeichnen(kochkurve, iterationen, kantenlaenge);
        kochkurve.turn(Math.PI / 1.5);


    }
    public static void zeichnen(Turtle kochkurve, int iterationen,double kantenlaenge ) {
        if(iterationen == 0) {
            kochkurve.penDown();
            kochkurve.forward(kantenlaenge);
        }
        else {
            zeichnen(kochkurve, iterationen - 1, kantenlaenge / 3);
            kochkurve.turn(-Math.PI / 3);

            zeichnen(kochkurve, iterationen - 1, kantenlaenge / 3);
            kochkurve.turn(Math.PI / 1.5);

            zeichnen(kochkurve, iterationen - 1, kantenlaenge / 3);
            kochkurve.turn(-Math.PI / 3);

            zeichnen(kochkurve, iterationen - 1, kantenlaenge / 3);

        }
    }
}
