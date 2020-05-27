//@author Maximlian Raspe
import java.awt.Color;

public class Feuer {

	public static final int R = 0;
	public static final int G = 1;
	public static final int B = 2;
	
	public static final int WIDTH = 200;
	public static final int HEIGHT = 150;
	
	public static void main(String[] args) {

		ImageFrame frame = new ImageFrame("Feuer");

	Color[][] colors = new Color[WIDTH][HEIGHT];

		// alle Pixel auf Schwarz setzen
		for (int i = 0; i < WIDTH; i++) {
			for (int j = 0; j < HEIGHT; j++) {
				colors[i][j] = Color.BLACK;
			}
		}
		
				
		while (true) {
			//erzeugt die keimpunkte	
			for(int i = 0; i <= 10; i++ ) {
				int x = (int)(Math.random() * 200);
				int y = 1;
				colors[x][y] = Color.yellow;
				
			}
			for(int i = 0; i <= 20; i++) {
				int x = (int)(Math.random()*200);
				int y = 1;
				colors[x][y] = Color.red;
				
			}
			for(int i = 0; i <= 10; i++) {
				int x = (int)( Math.random()* 200);
				int y = 1;
				colors[x][y] = Color.black;
			}
			
			for(int i = 1; i < WIDTH - 1; i++) {
				for(int a = 2; a < HEIGHT - 1; a++) {
					
					//rotwerte rausfinden
					int	dRot = colors[i][a - 1].getRed();
					int lRot = colors[i - 1][a].getRed();
					int rRot = colors[i + 1][a].getRed();
					int aRot = colors[i][a].getRed();
					
					//blauwerte rausfinden
					int	dBlau = colors[i][a - 1].getBlue();
					int lBlau = colors[i - 1][a].getBlue();
					int rBlau = colors[i + 1][a].getBlue();
					int aBlau = colors[i][a].getBlue();
					
					//grünwerte rausfinden
					int	dGruen = colors[i][a - 1].getGreen();
					int lGruen = colors[i - 1][a].getGreen();
					int rGruen = colors[i + 1][a].getGreen();
					int aGruen = colors[i][a].getGreen();
					
					//neue farbwerte berchnen
					int neuRot = ((aRot + rRot + lRot + dRot)*2 / 8);
					int neuBlau = ((aBlau + rBlau + lBlau + dBlau)*2 / 8);
					int neuGruen = ((aGruen + rGruen + lGruen + dGruen)*2 / 8);
					
					//neue farbe und punkt
					Color neueFarbe = new Color(neuRot, neuGruen, neuBlau);
					colors[i][a] = neueFarbe;
				}
			}

			ImageFrame.drawArray(colors);


			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
