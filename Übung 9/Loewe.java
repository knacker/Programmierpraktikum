//@author maximilian raspe
public class Loewe extends Tier {
    public Loewe(String tiername) {
        name = tiername;
        art = "Löwe";
        Schreiverhalten bruellen = new Bruellen();
        schreiverhalten = bruellen;
    }
}
