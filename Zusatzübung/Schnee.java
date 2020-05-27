//@author maximilian raspe
import java.awt.*;

public class Schnee {

    public static boolean[][] schnee = new boolean[79][26];
    public static void main (String[] args) {

        Console.setBackground(Color.black);
        Console.setForeground(Color.white);

		//schnee wird zufällig generiert und dann mit update snow nach unten fallen gelassen
        while(true) {
            int x1 = (int)Math.floor(Math.random() * 78) + 1;
            int x2 = (int)Math.floor(Math.random() * 78) + 1;
            int x3 = (int)Math.floor(Math.random() * 78) + 1;
            int x4 = (int)Math.floor(Math.random() * 78) + 1;
            int x5 = (int)Math.floor(Math.random() * 78) + 1;
            for(int y = 1; y <= 25; y++) {
               // Console.wait(50);
                updateSnow(x1, y);
               // Console.wait(50);
                updateSnow(x2, y);
               // Console.wait(50);
                updateSnow(x3, y);
               // Console.wait(50);
                updateSnow(x4, y);
              //  Console.wait(50);
                updateSnow(x5, y);
            }

        }
    }
	// lässt den schnee weiter nach unten fallen
    public static void updateSnow(int x, int y) {
        if(y == 25){
            Console.gotoXY(x, y);
            Console.write("");
            schnee[x][y] = true;
        }
        if(y < 25 && schnee[x][y + 1] == true) {
            Console.gotoXY(x, y - 1);
            Console.write(" ");
            Console.gotoXY(x, y - 1);
            Console.write("");
            schnee[x][y] = true;
        }
        else if(y < 25 && schnee[x][y + 1] == false) {
            Console.gotoXY(x, y - 1);
            Console.write(" ");
            Console.gotoXY(x, y);
            Console.write("*");
        }
    }
}
