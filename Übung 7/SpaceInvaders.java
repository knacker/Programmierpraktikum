//@author Maxmilian Raspe
/**
 *
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;



/**
 * @author Sonja 10.10.2018
 */
public class SpaceInvaders {

    private static boolean fertig = false;
    private static boolean schuss;
    private static int spaceBarX; // linker Rand der SpaceBar
    private static final int spaceBarY = 22; // Zeile der SpaceBar
    private static int obereGrenze = 5; // hoechste Zeile, in der Aliens
    // vorkommen
    private static int aktuellspaceBarX = 30;
    // Eine Konstante die angibt, dass sich die SpaceBar nach links bewegt.
    private static final boolean SPACE_BAR_MOVE_TO_THE_LEFT = true;

    // Eine Konstante die angibt, dass sich die SpaceBar nach rechts bewegt.
    private static final boolean SPACE_BAR_MOVE_TO_THE_RIGHT = false;

    private static int numberOfAliens = 0; // speichert die Anzahl der Aliens
    private static Timer alienTimer; // Timer fuer das Updaten der Aliens
    private static Timer bulletTimer; // Timer fuer das Updaten der Bullets

    /**
     * In der Console.java wurde ein KeyListener eingebunden, dessen Methoden in
     * der Console ganz unten implementiert sind. In einer dieser Methoden
     * stehen 2 Zeilen Code, wobei eine der Zeilen auf eine Methode der
     * Hauptklasse zugreift.
     */

    /**
     * @param args
     *            Programmargumente
     */
    public static void main(String[] args) {
        // Spiel vorbereiten
        prepareGame();

        // Timer erstellen
        initializeTimers();
        //Spiel starten
        startGame();
    }

    /**
     * Setzt Voreinstellungen fuer das Spiel und die initiale Setzung der
     * Objekte im Feld.
     */
    private static void prepareGame() {
        // Farben setzen
        Console.setBackground(Color.black);
        Console.setForeground(Color.white);
        Console.gotoXY(0, 0);
        Console.write("links - a, rechts - d, schießen - w");
        createAliens(); // Aliens erstellen
        spaceBarX = 10;
        drawSpaceBar(); // Spacebar erstellen
    }

    /**
     * Timer erstellen, initialisieren und starten. Sobalt die Timer gestartet
     * worden sind startet direkt das Spiel.
     */
    private static void initializeTimers() {
        // Timer fuer das Updaten der Bullets
        bulletTimer = new Timer(400, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // Display ausschalten, damit das Programm fluessig laeuft
                Console.displayOff();
                // Bullets updaten
                updateBullets();
                // Display wieder einschalten, aka Aenderungen wirksam machen
                Console.displayOn();
            }
        });

        // Timer fuer das Updaten der Aliens
        alienTimer = new Timer(5000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Console.displayOff();
                updateAliens();
                Console.displayOn();
            }
        });

        // damit keine Aktionen verschwinden
        bulletTimer.setCoalesce(true);
        alienTimer.setCoalesce(true);

        // Starten der Timer
        bulletTimer.start();
        alienTimer.start();
    }

    /**
     * Aktion nach Tasteneingabe. Bewegung nach links oder rechts
     * (moveSpaceBar(boolean)) mit entsprechender Eingabe) oder schiessen
     * (shoot()) einer Bullet.
     *
     * @param c
     *            Ueber Tastatur eingegebener char dem eine entsprechende
     *            Methode zugeordnet wird.
     */
    public static void move(char c) {
        // TODO
        char a = 'a';    //bestimmter tastendruck wird zugeordnet zu taste
        char d = 'd';
        char w = 'w';

        if(c == a) moveSpaceBar(true);
        if(c == d) moveSpaceBar(false);
        if(c == w) shoot();
    }

    /**
     * Erstellt Aliens zu Beginn des Spiels. Kann fuer mehrere Level erweitert
     * werden.
     *
     * Erstellt 11 * 5 Aliens im oberen, mittleren Bereich der Console.
     * Verwendet dazu die setAliensInHoricontalLine()-Methode.
     */
    private static void createAliens() {
        // TODO
        setAliensInHoricontalLine(28,3,11);		//setzt aliens
    }

    /**
     * Hilfsmethode zum Malen von Aliens in einer Reihe.
     *
     * @param column
     *            Spalte, in der die Reihe anfaengt.
     * @param row
     *            Zeile, in der die Reihe steht.
     * @param length
     *            Laenge der Reihe in Bezug auf Anzahl der Aliens ("@")
     */
    private static void setAliensInHoricontalLine(int column, int row, int length) {
        // TODO
        Console.setForeground(Color.green);	//zeichnet aliens, 11 aliens pro zeile, 5 zeilen
        for(int i = 3; i < 8; i++) {
            Console.gotoXY(column, i);
            for(int j = 0; j < length; j++) {
                Console.write(" @");
            }
        }
        numberOfAliens = 55;
        
        
    }

    /**
     * Verschiebt alle Aliens eine Zeile nach unten, prüft dabei mittels
     * isGameOver()-Methode ob die Aliens die Zeile der SpaceBar erreicht haben
     * und ruft dann die end(boolean)-Methode mit entsprechender Eingabe auf.
     */
    private static void updateAliens() { 

        Console.displayOff();
        for (int row=21; row >= 3; --row) {
            for (int column=0; column <= 77; column++) {
                Console.gotoXY(column, row-1);
                char upperRowContent = Console.getChar();
                Console.gotoXY(column, row);
                char lowerRowContent = Console.getChar();
                if (upperRowContent != lowerRowContent) {
                    Console.setForeground(Color.green);
                    Console.setChar(upperRowContent);
                }
            }
        }
        isGameOver();
        Console.displayOn();
    }

    /**
     * Testet ob die Aliens auf Höhe der Spacebar angekommen sind.
     *
     * @return true wenn das Spiel verloren wurde, false ansonsten
     */
    private static boolean isGameOver() {
    	if(numberOfAliens == 0) {
    		fertig = true;
    		end(true);
    	}
        for (int column=0; column < 77; column++) {
            Console.gotoXY(column, 21);
            if (Console.getChar() == '@') {
                fertig = true;
                end(false);
                return true;
            }
        }
        return false;
    }

    /**
     * Zeichnet die Spacebar an ihrer aktuellen Position (spaceBarX, spaceBarY).
     * Die SpaceBar sie wie folgt aus: "  ^  ".
     */
    private static void drawSpaceBar() {
        // TODO
        Console.setForeground(Color.yellow);
        Console.gotoXY(aktuellspaceBarX + spaceBarX , spaceBarY);
        Console.write(" ^ ");
        aktuellspaceBarX = spaceBarX + aktuellspaceBarX;
    }

    /**
     * Bewegt die Spacebar um eine Position (2 Stellen) nach links (true) oder
     * rechts (false). Es wird dabei zunächst geprüft, ob eine Bewegung in die
     * angegebene Richtung noch möglich ist. Sollte sich die SpaceBar bereits am
     * Rand des Spielfeldes befinden und weiter auf den Rand zu bewegen, so wird
     * diese Bewegung verworfen. Ruft am ende die drawSpaceBar()-Methode auf,
     * die die geupdatete SpaceBar zeichnet.
     *
     * @param direction
     *            Richtung, in welche sich die Spacebar bewegen soll. True steht
     *            für links, False für rechts.
     */
    private static void moveSpaceBar(boolean direction) {
        // TODO

        if(direction == false && aktuellspaceBarX < 77) {	// setzt spacebarx auf 1 um nach rechts zu laufen
            spaceBarX = 1;
            drawSpaceBar();
        }


        if(direction == true && aktuellspaceBarX > 0) {	//setzt spacebarx auf -1 um nach links zu laufen
            spaceBarX = -1;
            drawSpaceBar();
        }


    }

    /**
     * Schiesst eine neue Bullet "^". Die neue Bullet wird direkt ueber der
     * SpaceBar ins Feld geschrieben ausser es befindet sich in dieser direkt
     * ein Alien, dann wird dieses direkt getoetet.
     */
    private static void shoot() {
        // TODO
        schuss = true;
        int x = aktuellspaceBarX;	// schie�t eine bullet �ber dem aktuellen spacebar feld
        Console.setForeground(Color.red);
        Console.gotoXY(x + 1, 21);
        Console.write("^");
        Console.gotoXY(x + 1, 20);
        if(Console.getChar() == '@') {
            Console.write("");
            schuss = false;
        }
        updateBullets();
    }


    /**
     * Setzt akke Bullets eine Zeile weiter nach oben, falls eine Bullet auf ein
     * Alien trifft, wird dieses getoetet.
     */
    private static void updateBullets() {
        // TODO
        Console.displayOff();
        int x = aktuellspaceBarX;
        // update previous shots
        for(int y = 20; y >= 1; --y) {
            Console.gotoXY(x, y-1);
            // skip until we get to the update
            if (Console.getChar() != '^') {
                continue;
            }
            
            if (Console.getChar() == '@') {
                // ziel l�schen
                Console.write(" ");
                numberOfAliens--;	//wenn alien gestorben, wird 1 abgezogen
                break;
                
            } else {
                Console.setForeground(Color.red);
                // vorherige kugel l�schen
                Console.write(" ");
                // neue kugel setzen
                Console.gotoXY(x, y);
                Console.write("^");
            }                
        }
        
        // neuer schuss
        if(schuss == true) {
            schuss = false;
            x = aktuellspaceBarX;
            Console.gotoXY(x + 1, 20);
            Console.setForeground(Color.red);
        }
        
        Console.displayOn();
    }

    /**
     * Gibt das Ende des Spiels mit der Information ob es gewonnen oder verloren
     * wurde aus.
     *
     * Stoppt die beiden Timer.
     *
     * @param won
     *            Falls true ist das Spiel gewonnen, bei false ist das Spiel
     *            verloren.
     */
    private static void end(boolean won) {	//gibt den endstand aus
        alienTimer.stop();
        bulletTimer.stop();
        // TODO
        if(won == true) {
            Console.setForeground(Color.WHITE);
            Console.gotoXY(20, 5);
            Console.write("Gewonnen");
        }
        if(won == false) {
            Console.setForeground(Color.WHITE);
            Console.gotoXY(20, 5);
            Console.write("Verloren");
        }
    }
    private static void startGame() {

        while(fertig == false) {
            char c = Console.readKey();
            move(c);
            updateAliens();
        }
    }
}