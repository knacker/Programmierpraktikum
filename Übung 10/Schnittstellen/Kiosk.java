//@author maximilian raspe
import java.util.ArrayList;
import java.util.List;

public class Kiosk {

    private String name;
    private List<KioskInhalt> kioskinhalte = new ArrayList<KioskInhalt>();


    public Kiosk (String name) {
        this.name = name;
    }
	//fügt die kioskinhalte zu der liste hinzu
    public void addKioskInhalt(KioskInhalt inhalt) {
        kioskinhalte.add(inhalt);
    }
    public String toString() {
        String strReturn = name + ":\n";
		//geht die liste durch um so den artikel auszugeben
        for (KioskInhalt kioskInhalt : kioskinhalte) {
            strReturn += "\n" + kioskInhalt.getName();

            if (kioskInhalt instanceof Elektronisch) {
                strReturn += ", Stromverbrauch: " + ((Elektronisch) kioskInhalt).getStromverbrauch();
            }

            if (kioskInhalt instanceof Kaufbar) {
                strReturn += ", Preis: " + ((Kaufbar) kioskInhalt).getPreis();
            }
        }
        strReturn += "\n";
        return strReturn;
    }
}
