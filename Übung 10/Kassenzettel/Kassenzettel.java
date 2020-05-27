//@author maximilian raspe
import java.util.ArrayList;
import java.util.List;

public class Kassenzettel {

    private String name;
    private List<Eintrag> artikel = new ArrayList<Eintrag>();

	//konstruktor für kassenzettel namen
    public Kassenzettel(String name) {
        this.name = name;
    }
	//fügt einträge hinzu
    public void addEintrag(Eintrag gegenstand) {
        artikel.add(gegenstand);
    }
    public String toString() {
        String output = name + "\n \n";
        for(int i = 0; i <= artikel.size() - 1; i++) {
            output += artikel.get(i).getProduktname();
            output += "\n" + artikel.get(i).getMenge() + "x";
            output += "\t" + artikel.get(i).getPreis() + "€";
            output += "\n \n";
        }
        output += "-----------";
        output += "\n" + "Gesamtpreis \t" + artikel.get(artikel.size() - 1).getGesamtpreis() + "€";
        return output;
    }
}
