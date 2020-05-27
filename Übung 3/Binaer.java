import java.util.Scanner;
public class Binaer {

	public static void main(String[] args) {
		String rest = "";
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Zahl eingeben");
		int zahl = scan.nextInt();
		scan.close();
		
		while(zahl > 0) {
			rest = zahl % 2  + rest;
			zahl = zahl / 2;

			
			
		}
		System.out.print(rest);

	}

}
