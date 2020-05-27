//@author Maximilian Raspe
public class Turtle {
    private TurtleState state;
    private LineFrame draw;

    /**
     * Konstruktor der nur das LineFrame übergeben bekommt und den anderen
     * Konstruktor mit default-Werten aufruft.
     *
     * @param lineFrame
     *            Das Visualisierungsfenster, auf dem gezeichnet wird.
     */
    public Turtle(LineFrame lineFrame) {
        this(lineFrame, 0.5, 0.5, Math.PI / 2);
    }
    /**
     * Konstruktor, der Werte übergeben bekommt und diese den internen Feldern
     * zuweist.
     *
     * @param lineFrame
     *            Das Visualisierungsfenster, auf dem gezeichnet wird.
     * @param initX
     *            x-Position der Turtle
     * @param initY
     *            y-Position der Turtle
     * @param initAngle
     *            Ausrichtung (Winkel) der Turtle
     */
    public Turtle(LineFrame lineFrame, double initX, double initY, double initAngle) {
       draw = lineFrame;
       state = new TurtleState();

    }

    /**
     * Setzt den Stift auf dem Blatt ab.
     */
    public void penDown() {
        state.setDown(true);    //true = stift aufgesetzt, getDown um wert zu erfassen
    }

    /**
     * Hebt den Stift vom Blatt weg.
     */
    public void penUp() {
        state.setDown(false);   //false = stift oben
    }

    /**
     * Bewegt die Schildkröte um stepSize in die blickrichtung der Schildkröte.
     * StepSize hat dabei einen Wert zwischen 0 und 1, wobei 1 gleich einer
     * Bildschrimlänge entspricht.
     *
     * @param stepSize
     */
    public void forward(double stepSize) {

            double x0 = state.getX();
            double y0 = state.getY();
            double x1 = x0 + stepSize * Math.cos(state.getAngle());
            double y1 = y0 + stepSize * Math.sin(-state.getAngle());
            state.setX(x1);
            state.setY(y1);
            if(state.getDown() == true) {  //wenn stift unten, dann zeichnen
                draw.drawLine(x0, y0, x1, y1);
            }


    }

    /**
     * Dreht sich um den angegebenen Wert.
     *
     * @param angle
     *            Der Wert um den sich die Turtle dreht.
     */
    public void turn(double angle) {
        state.setAngle(state.getAngle() + angle);
    }
}
