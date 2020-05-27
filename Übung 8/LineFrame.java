import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Diese Klasse stellt ein GUI-Fenster bereit, in dem Linien dargestellt werden koennen.
 *
 * Die Darstellung erfolgt vektorbasiert und wird bei einer Groessenaenderung des
 * GUI-Fensters automatisch skaliert.
 *
 * @author pscb
 * @version 0.2
 */
public class LineFrame {

    private final double SCREEN_SCALE = 0.75;

    private JPanel drawPanel;

    private int currentPathLength = 0;
    private final int MAXIMUM_PATH_LENGTH = 1000;

    private Vector<Path2D> pathList = new Vector<Path2D>();

    private AffineTransform transformation = new AffineTransform();

    private Object mouseClicked = new Object();

    /**
     * Erzeugt ein GUI-Fenster in dem Linien dargestellt werden koennen.
     * Die Koordinate der linken oberen Ecke ist (0.0, 0.0), die der rechten unteren
     * Ecke ist (1.0, 1.0).
     *
     * @param title			Titel des GUI-Fensters
     */
    public LineFrame(String title) {
        JFrame frame = new JFrame(title);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int size = (int)Math.min(d.width * SCREEN_SCALE, d.height * SCREEN_SCALE);
        frame.setSize(size, size);
        frame.setLocation((d.width - frame.getSize().width) / 2,
                (d.height - frame.getSize().height) / 2);

        pathList.add(0, new Path2D.Double());

        drawPanel = new JPanel(false) {
            private static final long serialVersionUID = 1L;

            public void paint(Graphics g) {
                Graphics2D g2 = (Graphics2D)g;

                g2.setColor(Color.WHITE);
                g2.fillRect(0, 0, getWidth(), getHeight());

                double scaleX = getWidth() / 1.0;
                double scaleY = getHeight() / 1.0;
                transformation.setToScale(scaleX, scaleY);

                g2.setColor(Color.BLACK);
                synchronized(pathList) {
                    for (Path2D path : pathList) {
                        g2.draw(transformation.createTransformedShape(path));
                    }
                }
            }
        };
        frame.add(drawPanel);

        drawPanel.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                synchronized (mouseClicked) {
                    mouseClicked.notify();
                }
            }
        });

        frame.setVisible(true);
    }

    /**
     * Zeichnet eine duenne schwarze Linie.
     *
     * @param x0	x-Startkoordinate
     * @param y0	y-Startkoordinate
     * @param x1	x-Endkoordinate
     * @param y1	y-Endkoordinate
     */
    public void drawLine(double x0, double y0, double x1, double y1) {
        synchronized(pathList) {
            if (currentPathLength > MAXIMUM_PATH_LENGTH) {
                currentPathLength = 0;
                pathList.add(0, new Path2D.Double());
            } else {
                ++currentPathLength;
            }
            Path2D path = pathList.get(0);
            path.moveTo(x0, y0);
            path.lineTo(x1, y1);
        }
        drawPanel.repaint();
    }

    /**
     * Loescht alle Linien.
     */
    public void clear() {
        synchronized(pathList) {
            pathList.clear();
            pathList.add(0, new Path2D.Double());
            currentPathLength = 0;
        }
        drawPanel.repaint();
    }

    /**
     * Wartet, bis eine Mausklick in das GUI-Fenster erfolgt.
     */
    public void waitMouseClicked() {
        try {
            synchronized (mouseClicked) {
                mouseClicked.wait();
            }
        } catch (InterruptedException e) {
        }
    }

}
