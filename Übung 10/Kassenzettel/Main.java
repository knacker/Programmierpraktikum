//@author maximilian raspe
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        String produkt;
        int menge;
        double preis;
        boolean fertig = false;

        Kassenzettel zettel = new Kassenzettel("Kassenzettel");
        Scanner scan = new Scanner(System.in);
        while(fertig == false) {

            System.out.println("Produktnamen eingeben");
            produkt = scan.nextLine();
            if(produkt.equals("x")) {
                fertig = true;
                System.out.println(zettel);
                break;
            }
            System.out.println("Menge eingeben");
            menge = scan.nextInt();
            System.out.println("Preis eingeben");
            preis = scan.nextDouble();
            zettel.addEintrag(new Eintrag(produkt, menge, preis));
            scan.nextLine();

        }
        scan.close();
    }
}
