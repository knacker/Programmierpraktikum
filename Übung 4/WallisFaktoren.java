//@author maximlian Raspe
import java.util.Scanner;
public class WallisFaktoren {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		double genauigkeit = scan.nextDouble();
		scan.close();
		
		double result = 1;
		double x = 2;
		double y = 1;
		
		for(int i = 1; i <=1000000; i++) {	//schleife für wallis, zuerst zwischenergebnis, dann y+2, dann wieder zwischenergebnis, dann x+2
			result = x / y * result;
			y = y + 2;
			result = x / y * result;
			x = x + 2;
			
			if(Math.PI - genauigkeit < result * 2) { //prüft ob differenz < result * 2 ist
				System.out.println("Faktoren: " + i );
				System.out.println("0,1: 8");
				System.out.println("0,01: 78");
				System.out.println("0,001 : 785 ");
				System.out.println("0,0001 : 7854 ");
				System.out.println("0,00001 : 78540 ");
				break;

			}
		}	
		System.out.println("derzeitiges ergebnis : " + result * 2);
		System.out.println("pi " + Math.PI);
	}

}
