//@author maximilian raspe
public class Wolf extends Tier {

    public Wolf(String tiername) {
        name = tiername;
        art = "Wolf";
        Schreiverhalten heulen = new Heulen();
        schreiverhalten = heulen;
    }
}
