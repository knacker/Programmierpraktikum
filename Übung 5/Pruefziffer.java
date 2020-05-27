//@author Maximilian Raspe
import java.util.Scanner;
public class Pruefziffer {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Bitte Seriennummer eingeben ");
		String pruefziffer = scan.nextLine();
		scan.close();
		
		int buchstabenwert = 0;
		int zwischenergebnis = 0;
		int ergebnis;
		boolean wert = false;
		
		int[] Alphabet = {' ', 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',};	// array für zahlenwerte 1-26
		
		for(int i = 0; wert == false; i++) {
			if(pruefziffer.charAt(0) == Alphabet[i]) {	//ermittelt den buchstabenwert (1-26) und bildet die quersumme aus diesem
				buchstabenwert = (i % 10) + (i / 10);
				wert = true;	//sobald buchstabenwert ermittelt wird wert auf true gesetzt, was die schleife beendet
			}
			for(int a = 1; wert == true && pruefziffer.length() > a; a++) {	//schleife geht erst an, sobald buchstabenwert ermittelt wurde und berechnet dann die restliche quersumme
				zwischenergebnis = (int)pruefziffer.charAt(a) - '0' + zwischenergebnis;
			}
		}
		ergebnis = 8 - ((zwischenergebnis + buchstabenwert)%9);	// ist die prüfziffer
		if(ergebnis == 0) {	//wenn prüfziffer = 0, dann ist prüfziffer = 9
			System.out.print("Prüfziffer 9");
		}
		else {
			System.out.println("Prüfziffer " + ergebnis);
		}
	}
	
}
