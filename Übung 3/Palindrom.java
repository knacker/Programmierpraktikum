import java.util.Scanner;
public class Palindrom {

	public static void main(String[] args) {
		boolean palindrom = true;
		String wort;
		Scanner scan = new Scanner(System.in);
		System.out.println("name bitte");
		wort = scan.nextLine();	
		scan.close();
		int a = wort.length();
		
		for(int i = 1; i < wort.length() / 2; i++ ) {
			if(wort.charAt(i) != wort.charAt(a - i - 1) ) {
				
				palindrom = false;
			}
		}
		System.out.print(palindrom);
		
	}

}
