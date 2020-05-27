import java.util.Scanner;
public class Nachricht {

	public static void main(String[] args) {
		
		String text;
		int teilnachrichten;
		int x;
		int kosten = 0;
		
		System.out.println("Nachricht schreiben");
		Scanner scan = new Scanner(System.in);
		System.out.println("Wähle Anbieter");
		x = scan.nextInt();
		scan.nextLine();
		System.out.println("Bitte nachricht schreiben");
		text = scan.nextLine();
		scan.close();
		
	    if(text.length() > 30) {
			 teilnachrichten = (text.length() / 30) + 1;
	    }
	    else teilnachrichten = 1;
		switch (x) {
			case 1 : kosten = 15 + 6 * teilnachrichten;
			break;
			case 2 : kosten = 0 + 10 * teilnachrichten;
			break;
			case 3 : kosten = 70;
			break;
			case 4 : 
				if(teilnachrichten > 7 ) {
					kosten = 70;
					System.out.println("Anbieter 3 wurde genutzt");
				}
				else if(teilnachrichten > 3) {
					kosten = 15 + 6 * teilnachrichten;
					System.out.println("Anbieter 1 wurde genutzt");
				}
				else if(teilnachrichten <= 3) {
					kosten = 10 * teilnachrichten;
					System.out.println("Anbieter 2 wurde genutzt");
				}
			break;
		}
		System.out.println("Kosten : " + kosten + " Teilnachrichten : " + teilnachrichten);	
	}

}
