import java.awt.Color;

public class Laufband {

	public static void main(String[] args) {
		while(true) {
			for(int i = 0; i < 47; i++) {
				Console.gotoXY(i, 12);
				Console.write(" !!!Programmieren macht spaﬂ!!! ");
				Console.wait(20);
				Console.setForeground(Color.blue);
			
			}
			for(int a = 47; a > 0; a--) {
				Console.gotoXY(a, 12);
				Console.write(" !!!Programmieren macht spaﬂ!!! ");
				Console.wait(20);
				Console.setForeground(Color.red);
			}
		}
	}

}

