import java.awt.Color;

public class Spiegel {

	public static void main(String[] args) {
		
		int a = 0;
		int b = 80;
		while(true) {
			while(a < 40 && b > 40) {
				Console.setForeground(Color.CYAN);
				Console.gotoXY(a, 12);
				Console.write(" O ");
				Console.wait(25);
				Console.setForeground(Color.yellow);
				Console.gotoXY(b, 12);
				Console.write(" O ");
				Console.wait(25);
			
				a++;
				b--;
			}
			while(a > 0 && b < 80) {
				Console.setForeground(Color.CYAN);
				Console.gotoXY(a, 12);
				Console.write(" O ");
				Console.wait(25);
				Console.setForeground(Color.yellow);
				Console.gotoXY(b, 12);
				Console.write(" O ");
				Console.wait(25);
			
				a--;
				b++;
			}
		
		
		

		}

	}
}