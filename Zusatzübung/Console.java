import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Old-School-Konsole-Fenster angelehnt an die CRT-Unit von Borland.
 *
 * @author Denny Schneeweiß und Sven Löffler
 */
public class Console {

    // -------------------------------------------------------------------------------
    /** Singleton-Variable */
    private static Console INSTANCE = null;

    // ----------------------------------------------------------------------------
    private static final int DEFAULT_COLS = 80;
    private static final int DEFAULT_ROWS = 25;
    private static final String DEFAULT_TITLE = "PSCB Console";
    private static final int DEFAULT_COL_WIDTH = 12;
    private static final int DEFAULT_ROW_HEIGHT = 16;
    private static final int PADDING = 10;

    private static final int FONT_UP_SHIFT = 4;
    private static final int FONT_RIGHT_MARGIN = 3;
    // ----------------------------------------------------------------------------

    private String title	= DEFAULT_TITLE;
    private int cols 		= DEFAULT_COLS;
    private int rows 		= DEFAULT_ROWS;
    private int colWidth 	= DEFAULT_COL_WIDTH;
    private int rowHeight 	= DEFAULT_ROW_HEIGHT;

    private Font font = new Font("Arial", Font.BOLD, 12);

    // ----------------------------------------------------------------------------

    private int bufferedimageWidth;
    private int bufferedimageHeight;

    private BufferedImage frontBuffer;
    private BufferedImage backBuffer;
    private BufferedImage imgBuffer1;
    private BufferedImage imgBuffer2;
    private Graphics backBufferGraphics;
    private JFrame frame;
    private JPanel drawPanel;

    private int cursorX = 0;
    private int cursorY = 0;
    private Color background = Color.BLACK;
    private Color foreground = Color.WHITE;

    private boolean drawInstantly = true;
    private boolean showGrid = false;
    private boolean showCursor = true;
    // ----------------------------------------------------------------------------

    private static Console instance() {

        // prüfen, ob das Singleton schon erzeugt wurde
        if(INSTANCE == null) {

            // Console-Singleton erzeugen
            INSTANCE = new Console(DEFAULT_TITLE, DEFAULT_ROWS, DEFAULT_COLS);
        }

        // Singleton zurückliefern
        return INSTANCE;
    }

    // ----------------------------------------------------------------------------

    private ColorChar[][] inhalt = null;


    private  Console(String titel, int rows, int cols) {

        this.rows = rows;
        this.cols = cols;

        frame = new JFrame(titel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(this.cols * this.colWidth + 60, this.rows * this.rowHeight + 60);

        // ----------------------------------------------------------------------------
        // Zeichenmethode überschreiben, sodass der FrontBuffer genutzt wird.
        // Repaint wird vom Timer angestoßen.
        drawPanel = new JPanel(false) {
            private static final long serialVersionUID = 1L;

            @Override
            protected void paintComponent(Graphics g) {

                super.paintComponent(g);

                if(frontBuffer != null) {

                    // Synchronisation auf den FrontBuffer (blockieren, wenn der gerade geändert wird)
                    synchronized (frontBuffer) {

                        if (frontBuffer != null) {
                            g.drawImage(frontBuffer, 0, 0, getWidth(), getHeight(), null);
                        }
                    }
                }

            }

        };

        // ----------------------------------------------------------------------------
        // Animationstimer, der Buffer wird alle XX Millisekunden neu dargestellt

        Timer animationTimer = new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.repaint();
            }
        });

        animationTimer.start();
        // ----------------------------------------------------------------------------


        frame.add(drawPanel);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);

        frame.setVisible(true);


        // ----------------------------------------------------------------------------
        // Double-Buffering aufsetzen

        bufferedimageWidth = drawPanel.getWidth();
        bufferedimageHeight = drawPanel.getHeight();

        imgBuffer1 = new BufferedImage(bufferedimageWidth, bufferedimageHeight, BufferedImage.TYPE_INT_RGB);
        imgBuffer2 = new BufferedImage(bufferedimageWidth, bufferedimageHeight, BufferedImage.TYPE_INT_RGB);

        frontBuffer = imgBuffer1;
        backBuffer = imgBuffer2;
        backBufferGraphics = backBuffer.getGraphics();


        backBufferGraphics.setColor(background);
        backBufferGraphics.fillRect(0, 0, bufferedimageWidth, bufferedimageHeight);

        // ----------------------------------------------------------------------------
        // Inhalts-Array initialisieren

        this.inhalt = new ColorChar[this.cols][this.rows];

        for (int x = 0; x < this.cols; x++) {
            for (int y = 0; y < this.rows ; y++) {
                inhalt[x][y] = new ColorChar(' ', this.foreground,this.background);
            }
        }

        backBuffer.getGraphics().setFont(this.font);
        frontBuffer.getGraphics().setFont(this.font);
        frame.repaint();
    }

    /** Setzt den Cursor an die übergebenen Koordinaten innerhalb der Console */
    public static void gotoXY(int x, int y) {

        instance().setCursorXYP(x, y);

        if(instance().drawInstantly) {
            instance().drawArray();
        }
    }

    private void setCursorXYP(int x, int y) {

        if(x >= this.cols) {
            this.cursorX = this.cols-1;
        }
        else if(x < 0) {
            this.cursorX = 0;
        }
        else {
            this.cursorX = x;
        }


        if(y >= this.rows) {
            this.cursorY = this.rows-1;
        }
        else if(y < 0) {
            this.cursorY = 0;
        }
        else {
            this.cursorY = y;
        }
    }

    // ----------------------------------------------------------------------------
    /** Setzt die Hintergrundfarbe. */
    public static void setBackground(Color background) {

        instance().background = background;
    }


    // ----------------------------------------------------------------------------
    /** Setzt die Vordergrundfarbe. */
    public static void setForeground(Color foreground) {
        instance().foreground = foreground;
    }

    // ----------------------------------------------------------------------------
    /** Setzt das übergebene Zeichen an die aktuelle Cursor-Position mit
     *  den momenten gültigen Einstellungen für Vorder- und Hintergrundfarbe.
     */

    public static void setChar(char c) {

        Console instance = instance();

        instance.inhalt[instance.cursorX][instance.cursorY].setCharacter(c);
        instance.inhalt[instance.cursorX][instance.cursorY].setForgroundColor(instance.foreground);
        instance.inhalt[instance.cursorX][instance.cursorY].setBackgroundColor(instance.background);

        if(instance.drawInstantly) {
            instance.drawArray();
        }
    }

    // ----------------------------------------------------------------------------
    /** Schreibt die übergebene Zeichenkette mit den aktuellen Einstellungen für Vorder-
     *  und Hintergrundfarbe.
     */
    public static void write(String s) {

        instance().writeP(s);
    }

    // ----------------------------------------------------------------------------
    /** Schreibt die übergebene Zeichenkette mit den aktuellen Einstellungen für Vorder-
     *  und Hintergrundfarbe und fügt einen Zeilenumbruch an.
     */
    public static void writeln(String s) {

        instance().writeP(s + '\n');
    }

    // ----------------------------------------------------------------------------
    /** Bewirkt einen Zeilenumbruch. */
    public static void writeln() {

        instance().writeP("\n");
    }

    // ----------------------------------------------------------------------------
    private void writeP(String s) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(Character.isWhitespace(ch) && ch != '\n' && ch != ' ') {

                continue;
            }

            if(s.charAt(i) == '\n') {


                cursorX = 0;
                cursorY++;

            }
            else {

                this.inhalt[this.cursorX][this.cursorY].setCharacter(s.charAt(i));
                this.inhalt[this.cursorX][this.cursorY].setForgroundColor(this.foreground);
                this.inhalt[this.cursorX][this.cursorY].setBackgroundColor(this.background);

                cursorX++;

                if (cursorX >= this.cols) {
                    cursorX = 0;
                    cursorY++;
                }
            }

            if (cursorY >= this.rows) {

                Color fg = inhalt[this.cols-1][this.rows-1].forgroundColor;
                Color bg = inhalt[this.cols-1][this.rows-1].backgroundColor;

                cursorY = this.rows -1;
                for (int x = 0; x < this.cols; x++) {
                    for (int y = 1; y < this.rows; y++) {

                        inhalt[x][y-1].character = inhalt[x][y].character;
                        inhalt[x][y-1].forgroundColor = inhalt[x][y].forgroundColor;
                        inhalt[x][y-1].backgroundColor = inhalt[x][y].backgroundColor;
                    }
                }

                // neue Zeile mit den aktuellen Pinseleinstellungen belegen (HG, BG, Leer)
                for (int x = 0; x < this.cols; x++) {
                    inhalt[x][this.rows-1].character = ' ';
                    inhalt[x][this.rows-1].forgroundColor = fg; // this.foreground;
                    inhalt[x][this.rows-1].backgroundColor = bg; // this.background;
                }
            }
        }

        if(this.drawInstantly) {
            drawArray();
        }
    }


    // ----------------------------------------------------------------------------
    /** Löscht die Konsole und setzt die Einstellunge für Vorder- und
     *  Hintergrundfarbe aller Zeichen auf die aktuellen Einstellungen der Konsole.
     */
    public static void clear() {

        instance().clearP();
    }

    // ----------------------------------------------------------------------------
    private void clearP() {

        this.setCursorXYP(0, 0);

        for (int x = 0; x < this.cols; x++) {
            for (int y = 0; y < this.rows; y++) {

                inhalt[x][y].character = ' ';
                inhalt[x][y].backgroundColor = this.background;
                inhalt[x][y].forgroundColor = this.foreground;
            }
        }

        if(this.drawInstantly) {
            drawArray();
        }
    }


    // ----------------------------------------------------------------------------
    /** Zeichnet das Array neu in den Backbuffer und macht anschließend den Buffertausch. */

    private void drawArray() {

        backBufferGraphics.setFont(this.font);

        backBufferGraphics.clearRect(0, 0, bufferedimageWidth, bufferedimageHeight);

        for (int x = 0; x < this.cols; x++) {
            for (int y = 0; y < this.rows; y++) {

                if (inhalt[x][y] != null) {


                    backBufferGraphics.setColor(inhalt[x][y].getBackgroundColor());

                    backBufferGraphics.fillRect (
                            PADDING + x * this.colWidth,
                            PADDING + y * this.rowHeight,
                            this.colWidth,
                            this.rowHeight
                    );


                    if(this.showGrid) {

                        backBufferGraphics.setColor(Color.GRAY);

                        backBufferGraphics.drawRect (
                                PADDING + x * this.colWidth,
                                PADDING + y * this.rowHeight,
                                this.colWidth,
                                this.rowHeight
                        );
                    }

                    backBufferGraphics.setColor(inhalt[x][y].getForgroundColor());

                    backBufferGraphics.drawString (
                            inhalt[x][y].getCharacter() + "",
                            PADDING + x * this.colWidth + FONT_RIGHT_MARGIN,
                            PADDING + y * this.rowHeight + this.rowHeight - FONT_UP_SHIFT
                    );

                }
            }
        }

        if(this.showCursor) {

            backBufferGraphics.setColor(Color.white);
            backBufferGraphics.drawRect(
                    PADDING + this.cursorX * this.colWidth,
                    PADDING + this.cursorY * this.rowHeight,
                    this.colWidth,
                    this.rowHeight
            );
        }


        backBufferGraphics.setColor(Color.WHITE);
        backBufferGraphics.drawRect(
                PADDING -1,
                PADDING -1,
                this.cols * this.colWidth + 1,
                this.rows * this.rowHeight + 1
        );



        // frame.repaint();
        switchBuffer();
    }

    // ----------------------------------------------------------------------------

    /**
     * Lässt das Programm für die angegebene Zeit warten.
     *
     * @param time Die Zeit in Millisekunden die gewartet werden soll.
     */
    public static void wait(int time) {

        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // ----------------------------------------------------------------------------
    /** Sorgt dafür, dass die folgenden Konsolenaktionen nicht dargestellt werden,
     *  bis displayOn() aufgerufen wird. Dient zur Beschleunigung und wirkt sich nur
     *  auf Schreib- und Zeichenmethoden aus.
     */
    public static void displayOff() {

        instance().drawArray();
        instance().drawInstantly = false;
    }

    /** Aktualisiert die Anzeige der Konsole, sofern vorher displayOff()
     *  aufgerufen wurde.
     */
    public static void displayOn() {

        instance().drawInstantly = true;
        instance().drawArray();
    }
    // ----------------------------------------------------------------------------
    /** Unterbricht das Programm so lange, bis die Leertaste gedrückt wurde. */
    public static void waitSpaceKey() {

        instance().waitKeyP();
    }
    // ----------------------------------------------------------------------------
    private void waitKeyP() {
        final CountDownLatch latch = new CountDownLatch(2);
        KeyEventDispatcher dispatcher = new KeyEventDispatcher() {

            // Anonymous class invoked from EDT
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE)
                    latch.countDown();
                return false;
            }
        };
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        try {
            latch.await();
        } catch (InterruptedException e1) {

            e1.printStackTrace();
        }
        // current thread waits here until countDown() is called
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);


        try {
            Thread.sleep(50);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    // ----------------------------------------------------------------------------
    /** Wartet auf einen Tastendruck und gibt den Zeichencode als char-Wert zurück. */
    public static char readKey() {

        return instance().readKeyP();
    }

    // ----------------------------------------------------------------------------
    private class KeyChar {

        private char ch;
        public void setChar(char c) {
            this.ch = c;
        }
    }

    private char readKeyP() {

        final CountDownLatch latch = new CountDownLatch(2);
        final KeyChar kc = new KeyChar();

        KeyEventDispatcher dispatcher = new KeyEventDispatcher() {
            // Anonymous class invoked from EDT
            public boolean dispatchKeyEvent(KeyEvent e) {
                latch.countDown();
                kc.setChar(e.getKeyChar());
                return false;
            }
        };

        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(dispatcher);
        try {
            latch.await();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        // current thread waits here until countDown() is called
        KeyboardFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(dispatcher);


        try {
            Thread.sleep(50);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        return kc.ch;
    }

    // ----------------------------------------------------------------------------
    /** Schaltet die Darstellung des Zeilen- und Spaltenrasters ein und aus. */

    public static void showGrid(boolean show) {

        instance().showGrid = show;

        if(INSTANCE.drawInstantly)
            instance().drawArray();
    }

    // ----------------------------------------------------------------------------
    /** Schaltet die Darstellung des Cursors ein und aus. */

    public static void showCursor(boolean show) {

        instance().showCursor = show;

        if(INSTANCE.drawInstantly)
            instance().drawArray();
    }
    // ----------------------------------------------------------------------------
    private class ColorChar {

        private Color backgroundColor = Color.BLUE;

        private Color forgroundColor = Color.YELLOW;

        private char character;

        public ColorChar(char character, Color fgColor, Color bgColor) {
            this.character = character;
            this.backgroundColor = bgColor;
            this.forgroundColor = fgColor;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }

        public void setBackgroundColor(Color backgroundColor) {
            this.backgroundColor = backgroundColor;
        }

        public Color getForgroundColor() {
            return forgroundColor;
        }

        public void setForgroundColor(Color forgroundColor) {
            this.forgroundColor = forgroundColor;
        }

        public char getCharacter() {
            return character;
        }

        public void setCharacter(char character) {
            this.character = character;
        }

    }
    // ----------------------------------------------------------------------------
    /** Tauscht Back- und Frontbuffer. */
    private void switchBuffer() {

        synchronized (frontBuffer) {

            if(backBuffer == imgBuffer1) {

                backBuffer = imgBuffer2;
                frontBuffer = imgBuffer1;
            }
            else {
                backBuffer = imgBuffer1;
                frontBuffer = imgBuffer2;
            }

            backBufferGraphics = backBuffer.getGraphics();

        }

    }
}
