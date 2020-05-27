//@author maximilian raspe
import java.util.Scanner;
public class Assertions {
    public static void main(String[] args) {
        int laenge;
        //Bruch bruch1 = new Bruch(3, 4);
        //System.out.println(bruch1);
        Scanner scan = new Scanner(System.in);
        System.out.println("Zahl a eingeben");
        int a = scan.nextInt();
        System.out.println("Zahl b eingeben");
        int b = scan.nextInt();
        assert a >= 1 : "Zahlen sind nicht größergleich 1";
        assert b >= 1 : "Zahlen sind nicht größergleich 1";
        Bruch bruch1[] = new Bruch[a];
        Bruch bruch2[] = new Bruch[b];
        if (a > b) {
            laenge = a;
        } else {
            laenge = b;
        }
        Bruch resultArray[] = new Bruch[laenge];	
		//brüche für den ersten array eingeben
        for (int i = 0; i < a; i++) {
            int zaehler;
            int nenner;
            System.out.println("zaehler eingeben(bruch1)");
            zaehler = scan.nextInt();
            System.out.println("nenner eingeben(bruch1)");
            nenner = scan.nextInt();
            assert nenner != 0 : "Zahl muss ungleich 0 sein";
            bruch1[i] = new Bruch(zaehler, nenner);
        }
		//brüche für den 2. array eingeben
        for (int i = 0; i < b; i++) {
            int zaehler;
            int nenner;
            System.out.println("zaehler eingeben(bruch2)");
            zaehler = scan.nextInt();
            System.out.println("nenner eingeben(bruch2)");
            nenner = scan.nextInt();
            assert nenner != 0 : "Zahl muss ungleich 0 sein";
            bruch2[i] = new Bruch(zaehler, nenner);
        }
        scan.close();
		//multipliziert die brüche
        for (int m = 0; m < a; m++) {
            int nennerNeu = bruch1[m].getNenner() * bruch2[m].getNenner();
            int zaehlerNeu = bruch1[m].getZaehler() * bruch2[m].getNenner() + bruch2[m].getZaehler() * bruch1[m].getNenner();
            resultArray[m] = new Bruch(zaehlerNeu, nennerNeu);
        }
		//dividiert die brüche
        for (int i = 1; i < resultArray.length; i++) {
            int zaehlerNeu = resultArray[0].getZaehler() * resultArray[i].getNenner();
            int nennerNeu = resultArray[0].getNenner() * resultArray[1].getZaehler();
            assert nennerNeu != 0 : "Nenner muss ungleich 0 sein";
            resultArray[i] = new Bruch(zaehlerNeu, nennerNeu);
        }
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }
}
