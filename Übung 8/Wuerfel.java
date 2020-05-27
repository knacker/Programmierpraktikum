


public class Wuerfel {

    public static void main(String[] args) {
        wuerfel();
    }

    public static void wuerfel() {

        Turtle wurfel = new Turtle(new LineFrame("Würfel"));

        wurfel.penUp(); // zur mitte der lineframe springen
        wurfel.turn(-Math.PI / 4);
        wurfel.forward(0.5);

        wurfel.penDown();
        wurfel.turn(Math.PI / 4);
        wurfel.forward(0.2);
        wurfel.turn(-Math.PI / 2);
        wurfel.forward(0.2);
        wurfel.turn(-Math.PI / 2);
        wurfel.forward(0.2);
        wurfel.turn(-Math.PI / 2);
        wurfel.forward(0.2);
        wurfel.turn(-Math.PI / 4);
        wurfel.forward(0.1);
        wurfel.turn(-Math.PI / 4);
        wurfel.forward(0.2);
        wurfel.turn(5*Math.PI / 4);
        wurfel.forward(0.1);
        wurfel.turn(Math.PI / 4);
        wurfel.forward(0.2);
        wurfel.turn(3 * Math.PI / 4);
        wurfel.forward(0.1);
        wurfel.turn(Math.PI / 4);
        wurfel.forward(0.2);
        wurfel.penUp();

    }

}
