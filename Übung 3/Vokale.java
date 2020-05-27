import java.util.Scanner;
public class Vokale {

	public static void main(String[] args) {
		String wort;
		int vokale = 0;
		int konsonanten = 0;
		int rest = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("name bitte");
		wort = scan.nextLine();
		System.out.println("Danke anke");
		scan.close();
		wort.toLowerCase();
		
		for(int i = 0; i < wort.length(); i++) {
			if(wort.charAt(i) == 'a' | wort.charAt(i) == 'e'| wort.charAt(i) == 'i' | wort.charAt(i) == 'o' | wort.charAt(i) == 'u') {
				vokale++;
			}
			if(wort.charAt(i) == 'b' | wort.charAt(i) == 'c' | wort.charAt(i) == 'd' | wort.charAt(i) == 'f' | wort.charAt(i) == 'g' | wort.charAt(i) == 'h' | wort.charAt(i) == 'j' | wort.charAt(i) == 'k' | wort.charAt(i) == 'l' | wort.charAt(i) == 'm' | wort.charAt(i) == 'n' | wort.charAt(i) == 'p' |  wort.charAt(i) == 'q' | wort.charAt(i) == 'r' |wort.charAt(i) == 's' | wort.charAt(i) == 't' | wort.charAt(i) == 'v' | wort.charAt(i) == 'w' | wort.charAt(i) == 'x' | wort.charAt(i) == 'y' | wort.charAt(i) == 'z') {
				konsonanten++;
			}
			rest = wort.length() - vokale - konsonanten;		
			
		
		}
		System.out.print("vokale :" + vokale + " konsonanten :" + konsonanten + " rest :" + rest);
	}
}

	 	
