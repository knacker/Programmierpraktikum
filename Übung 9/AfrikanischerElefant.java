//@author maximilian raspe
public class AfrikanischerElefant extends Elefant {
	//konstruktor für den afrikanischen elefanten
    public AfrikanischerElefant(String tiername) {
        super(tiername);
        super.art = "Afrikanische Elefant";
    }
	//default konstruktor
    public AfrikanischerElefant() {
    }
    public String zeigeMarkenzeichen() {
        return name + " wackelt mit seinen großen Ohren";
    }
	//überschreibt die toString methode aus tier
    public String toString() {
        return super.toString()+ "\n" + this.zeigeMarkenzeichen();
    }
}
