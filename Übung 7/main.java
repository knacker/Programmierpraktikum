public class main {

    public static void main(String[] args) {

        Bruch bruch1 = new Bruch(3);
        Bruch bruch2 = new Bruch(3, 5);
        Bruch bruch3 = new Bruch(2, 3);


        Bruch result1 = Bruch.Subtrahieren(Bruch.Addieren(bruch1, bruch2), bruch3);
        result1.dezimalBruch();
        result1.kuerzeBruch();

        System.out.println("");

        Bruch result2 = Bruch.Dividieren(Bruch.Multiplizieren(bruch1, bruch2), bruch3);
        result2.dezimalBruch();
        result2.kuerzeBruch();
    }
}
