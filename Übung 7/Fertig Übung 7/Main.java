//@author Maximiian Raspe
public class Main {

    public static void main(String[] args) {

        Bruch bruch1 = new Bruch(3, 6);
        Bruch bruch2 = new Bruch(3, 5);
        Bruch bruch3 = new Bruch(2, 3);


        Bruch result1 = Bruch.Subtrahieren(Bruch.Addieren(bruch1, bruch2), bruch3);
        System.out.println("Normaler Bruch : " + result1);
        result1.dezimalBruch();
        result1.kuerzeBruch();
        System.out.println("Gekuerzter bruch : " + result1);

        System.out.println("");

        Bruch result2 = Bruch.Dividieren(Bruch.Multiplizieren(bruch1, bruch2), bruch3);
        System.out.println("Normaler Bruch : " + result2);
        result2.dezimalBruch();
        result2.kuerzeBruch();
        System.out.println("Gekuerzter bruch : " + result2);
    }
}
