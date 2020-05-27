import java.util.Scanner;
public class Schachbrett {

	public static void main(String[] args) {
		int größe;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Größe bitte");
		größe = scan.nextInt();
		System.out.println("Vielen Lieben Dank");
		scan.close();
		
		for(int a = 0; a < größe; a++) {
		
			for(int i = 0; i < größe; i++) {
				System.out.print("# ");
			}
		System.out.println(" ");

		}
	}
}
