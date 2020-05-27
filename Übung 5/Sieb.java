//@author Maximilian Raspe
import java.util.Arrays;
import java.util.Scanner;
public class Sieb {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int grenze = scan.nextInt();
		int[] zahlen = new int [grenze +1];
		int[] fertig = new int[grenze + 1];
		boolean [] gesiebt = new boolean[grenze +1];

		scan.close();
		
		for(int i = 2; i <= grenze  ; i++) {	//füllt den array mit zahlen und setzt alle zahlen in gesiebt auf true
			zahlen[i] = i;
			gesiebt[i] = true;
		}
		for(int i = 2; i < grenze; i++) {
			for(int a = 1; a <= grenze / i; a++) {
				if  (i * a != i) {	// wenn i * a ungleich i ist, wird i * a auf false gesetzt, was die primzahlen übrig lässt
					gesiebt[i * a] = false;
				}
			}
		}
		for(int i = 0; i <= grenze; i++) {	// vergleicht nochmal die gesiebten werten und wenn diese true sind, wird i als zahl in die liste gespeichert
			if(gesiebt[i] == true) {
				fertig[i] = i;
			}
		}

		System.out.print(Arrays.toString(fertig));
	
	}

}
