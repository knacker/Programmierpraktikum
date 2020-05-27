import java.util.Scanner;
public class Namen {

	public static void main(String[] args) {
		String wort1;
		String wort2;
		Scanner scan = new Scanner(System.in);
		System.out.println("name 1 bitte");
		wort1 = scan.nextLine();
		System.out.println("name 2 bitte");
		wort2 = scan.nextLine();
		scan.close();
		if (wort1.length() > wort2.length()) {
			System.out.println(wort1 + " hat mehr buchstaben als " + wort2);
		}
		if (wort2.length() > wort1.length()) {
			System.out.println(wort2 + " hat mehr buchstaben als " + wort1);
		
		}
		if (wort2.length() == wort1.length()) {
			System.out.println(wort2 + " hat gleich viele buchstaben wie " + wort1);
		}	

	}

}
