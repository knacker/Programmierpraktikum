//@author maximilian raspe
import java.util.Scanner;
public class Schachbrett {
public static int counter = 1;	//zählt die durchläufe, springt in neue zeile wenn fertig
public static int iterationsCounter;	//hilft um zu bestimmen, wann aus der "Schleife" rausgesprungen werden soll
public static int switchmuster = 0;	//hilfsvariable um das schachbrettmuster zu malen
	
public static void main(String[] args) {
	
		Scanner groesse = new Scanner(System.in);
		System.out.println("Größe eingeben");
		int n = groesse.nextInt();
		groesse.close();
		
		iterationsCounter = n;
		System.out.println("Schachbrett : ");
		schachbrettZeichnen(n);
		

	}
	
	public static void schachbrettZeichnen(int n) {
		boolean fertig = false;	//hilft um "schleife" zu beenden
		String muster1 = " X O";
		String muster2 = " O X";
		if(iterationsCounter - n >= n * n / 2) fertig = true;	//wenn n*n zeichen, also das gesamte schachfeld entstanden ist, hört er auf zu zeichnen
		if(counter <= n / 2 && fertig == false) {	//zeichnet in zeile die felder
			if(switchmuster % 2 == 0)System.out.print(muster1);	//switchmuster eine gerade zahl ist, dann muster 1, ansonsten muster 2; hilft um das schachbrett muster zu generieren
			if(switchmuster % 2 != 0)System.out.print(muster2);
			counter++;
			iterationsCounter++;	//zählt die summe aller entstehenden zeichen
			schachbrettZeichnen(n);
		}
		else if(counter > n / 2 && fertig == false) {	//springt in die nächste zeile
			counter = 1;	//setzt den zähler wieder auf 1 um n zeichen zu malen
			System.out.println("");
			switchmuster++;
			schachbrettZeichnen(n);	
		}
	}

}
