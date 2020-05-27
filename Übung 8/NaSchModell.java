//@author maximilian raspe
import java.util.Scanner;
public class NaSchModell {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Fahrbahngröße eingeben");
        int fahrbahngroesse = scan.nextInt();
        System.out.println("Fahrzeug Anzahl eingeben");
        int fahrzeuganzahl = scan.nextInt();
        System.out.println("Maximalgeschwindigkeit eingeben");
        int maxgeschwindigkeit = scan.nextInt();
        System.out.println("Trödelwahrscheinlichkeit zwischen 0 und 1 eingeben");
        double wahrscheinlichkeit = scan.nextDouble();
        System.out.println("Updateanzahl eingeben");
        int updatezahl = scan.nextInt();
        scan.close();

        Fahrbahn strecke = new Fahrbahn(fahrbahngroesse, fahrzeuganzahl, maxgeschwindigkeit, wahrscheinlichkeit);

        // Initialausgabe
        strecke.ausgeben();

        // Updates
        for (int i = 1; i < updatezahl; i++) {
            strecke.update();
            strecke.ausgeben();
        }
    }

}