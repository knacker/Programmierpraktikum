//@author maximilian raspe
public class Elefant extends Tier {
	//constructor für den elefanten
    public Elefant(String tiername) {
        name = tiername;
        art = "Elefant";
        Schreiverhalten troeten = new Troeten();
        schreiverhalten = troeten;
    }
    public Elefant() {
    }
    public void stampfen() {
        System.out.println("Wenn er auf den Boden stampft zittert die Erde");
    }

}