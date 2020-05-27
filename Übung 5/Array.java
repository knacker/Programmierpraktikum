//@author Maximilian Raspe
import java.util.Arrays;
import java.util.Scanner;
public class Array {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Wie viel Zahlen möchten sie eingeben");
		int anzahl = scan.nextInt();
		int[] zahlen = new int [anzahl];
		int produkt = 1;
		int summe = 0;

		for(int i = 0; i < zahlen.length; i++) {	//scannt ints ein und speichert diese am i-ten index
			System.out.println("Zahl eingeben");
			zahlen[i] = scan.nextInt();
			System.out.println("Bisherige Zahlen : " + Arrays.toString(zahlen));
		}
		
		scan.close();
		
		for(int i = 0; i < zahlen.length; i++) {	// berechnet produkt mit produkt = produkt*zahlen[i], das gleiche bei summe
			produkt *= zahlen[i];
			summe += zahlen[i];
		}
		Arrays.sort(zahlen);	// sortiere zahlen um größte, kleinste auszugeben
		System.out.println(Arrays.toString(zahlen));
		System.out.println("Kleinste : " + zahlen[0]);
		System.out.println("Größte : " + zahlen[anzahl - 1]);
		System.out.println("Produkt : " + produkt);
		System.out.println("Summe : " + summe);
		System.out.print("Durchschnitt : " + (double)summe / anzahl);
	}
}
