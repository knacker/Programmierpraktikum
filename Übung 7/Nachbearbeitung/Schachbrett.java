//@author maximilian raspe
import java.util.Scanner;
public class Schachbrett {

public static void main(String[] args) {
	
		Scanner groesse = new Scanner(System.in);
		System.out.println("Größe eingeben");
		int n = groesse.nextInt();
		groesse.close();

		int m = n;	//m um n wieder auf n zu setzen
		int k = n;	// k um die zeilen zu zählen
		System.out.println("Schachbrett : ");
		//schachbrettZeichnen(n);
		schachbrettZeichnen(n, m, k);

	}

	public static void schachbrettZeichnen(int n, int m, int k) {	//schachbrett wird wieder mit n(spalte), m(hilfsvariable) und k(zeile) augerufen

		String muster1 = " X ";
		String muster2 = " O ";

		if(n == 0) {
			System.out.println("");
			n = m;	//n wird wieder auf 4 gesetzt
			if(k == 1) System.exit(1);	//beendet das programm sobald die letzte zeile geschrieben wurde
			k--;	//1 zeile wird abgezogen
			schachbrettZeichnen(n, m, k);	//wird neu aufgerufen mit neuen parametern
		}
		if(n > 0 && n % 2 == 0) {	//bedingungen um das schachbrettmuster zu erzeugen
			if(k % 2 != 0) {	
				System.out.print(muster2);
				schachbrettZeichnen(n - 1, m, k);
			}
			else {
				System.out.print(muster1);
				schachbrettZeichnen(n - 1, m, k);
			}
		}
		if(n > 0 && n % 2 != 0) {
			if(k % 2 == 0) {
				System.out.print(muster2);
				schachbrettZeichnen(n - 1, m, k);
			}
			else {
				System.out.print(muster1);
				schachbrettZeichnen(n - 1, m, k);
			}
		}
	}
}
