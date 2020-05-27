import java.util.Scanner;
public class Zahlen {

	public static void main(String[] args) {
		int a;
		int b;
		int c;
		int summe;
		double durchschnitt;
		int produkt;
		
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		scan.close();
		
		summe = a + b +c;
		durchschnitt = (a + b +c) / 3;
		produkt = a * b *c;
		
		System.out.println(summe);
		System.out.println(durchschnitt);
		System.out.println(produkt);
		
		if (a > b && a > c) {
			System.out.println("Größte:" + a);
		}
		if (b > a && b > c) {
			System.out.println("Größte:" + b);
		}
		if (c > a && c > b) {
			System.out.println("Größte:" + c);
		}
		if (a < b && a < c) {
			System.out.println("Kleinste" + a);
		}
		if (b < a && b < c) {
			System.out.println("Kleinste" + b);
		}
		if (c < b && c < a) {
			System.out.println("Kleinste" + c);
		}
	}

}
