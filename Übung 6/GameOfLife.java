//@author maximlian Raspe
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

/**
 * Das Spiel Game of Life
 * 
 * @author Sven Loeffler
 * @date 16.11.2017
 * @version 1.0
 */
public class GameOfLife {

	private static final int FREQUENCY = 15;
	private final static double SPEED = 0.25;

	/**
	 * Die auszuf√ºhrende Methode, wenn das Programm gestartet wird.
	 * 
	 * @param args
	 *            Die Programmargumente.
	 */
	public static void main(String[] args) {

		JFrame frame = setFrame();
		boolean[][] cells = generateCells();

		// Schleife die das Spielfeld permanent neu zeichnet.
		while (true) {
			cells = conwaysRules(cells);
			frame.add(BorderLayout.CENTER, new MapView(cells));
			frame.setVisible(true);

			try {
				Thread.sleep((int) (SPEED * 1000));
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}

	}

	/**
	 * Erzeugt ein neues Frame (Fenster) und stellt es richtig ein.
	 * 
	 * @return Das erzeugte Frame.
	 */
	public static JFrame setFrame() {
		JFrame frame = new JFrame();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = new Dimension((int) (screenSize.width), (int) (screenSize.height));
		int frameWidth = MapView.getCELLSIZE() * 102 + 16;
		int frameHeight = MapView.getCELLSIZE() * 102 + 38;
		frame.setBounds((int) (0.5 * (frameSize.width - frameWidth)), (int) (0.5 * (frameSize.height - frameHeight)),
				frameWidth, frameHeight);

		frame.setTitle("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		return frame;
	}

	/**
	 * Gibt ein zweidimensionales (x- und y-Koordinate) boolean-Array mit
	 * zuf√§ligem Inhalt aus, dabei entspricht true einer lebenden und false eine
	 * tote Zelle.
	 * 
	 * @return Zweidimensionales Array mit lebenden und toten Zellen.
	 */
	public static boolean[][] generateCells() {
		boolean[][] cells = new boolean[102][102];

		for (int y = 1; y <= 100; y++) {
			for (int x = 1; x <= 100; x++) {
				int random = (int) (Math.random() * 10);
				if (random < (FREQUENCY / 10)) {
					cells[x][y] = true;
				} else {
					cells[x][y] = false;
				}
			}
		}

		for (int i = 0; i <= 101; i++) {
			cells[i][0] = false;
			cells[i][101] = false;
			cells[0][i] = false;
			cells[101][i] = false;
		}

		return cells;

	}

	/**
	 * Liest ein zweidimensionales Array von Zellen ein, auf dem die von Conway
	 * formulierten Regeln angewandt werden. Die aus den Regeln entstandenen
	 * toten und lebenden Zellen werden in einem neuen Array gespeichert und
	 * ausgegeben.
	 * 
	 * @param cells
	 *            Das Array der Zellen, das ausgelesen wird.
	 * 
	 * @return Neues zweidimensionales Array mit lebenden und toten Zellen.
	 */

	public static boolean[][] conwaysRules(boolean[][] cells) {
		boolean newCells[][] = new boolean[102][102];		// array f√ºr neue zellen
		
		for(int y = 1; y <= 100; y++) {		//durchl‰uft den array f¸r jeden x und y wert
			for(int x = 1; x <= 100; x++) {
				
				int counterAlive = 0;	//z‰hlt benachbarte zellen
				
				if(cells[x + 1][y ] == true) counterAlive++;	
				if(cells[x + 1][y + 1 ] == true) counterAlive++;
				if(cells[x + 1][y - 1] == true) counterAlive++;
				if(cells[x][y + 1] == true) counterAlive++;
				if(cells[x][y - 1 ] == true) counterAlive++;
				if(cells[x - 1][y ] == true) counterAlive++;
				if(cells[x - 1][y + 1] == true) counterAlive++;
				if(cells[x - 1][y - 1] == true) counterAlive++;
				
				//conway regeln
				if(counterAlive == 3 && cells[x][y] == false) newCells[x][y] = true;	// tote zelle mit 3 benachbarten zellen = lebende zelle

				if(counterAlive < 2 && cells[x][y] == true) newCells[x][y] = false;	//lebende zelle mit weniger als 2 nachbarn = tote zelle

				if((counterAlive == 2 || counterAlive == 3) && cells[x][y] == true) newCells[x][y] = true;	//lebende zelle mit weniger als 2 oder 3 nachbarn = lebende zelle

				if(counterAlive > 3 && cells[x][y] == true) newCells[x][y] = false;	//lebende zelle mit weniger als 2 oder 3 nachbarn = lebende zelle
				}
				
			}

		return newCells;	//@return newCells
	}

}