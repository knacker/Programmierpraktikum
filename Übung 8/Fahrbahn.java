//@author maximilian raspe
public class Fahrbahn {

    private Auto[] autosZellen;
    private int anzahlZellen;
    private int maxGeschwindigkeit;
    private double troedel;

    /**
     * Konstruktor, der einen Array der Zellen Größe erstellt von typ Klasse Auto,
     * und rechnet auf Basis der Eingaben wie Groß der Abstand zwischen zwei Autos
     * ist.
     *
     * @param zellen             wie Groß die Bahn ist.
     * @param anzahlAutos        wie viele Autos haben wir als Eingabe bekommen.
     * @param maxGeschwindigkeit Maximale Geschwindigkeit als Eingabe.
     * @param troedel            Trödelwahrscheinlichkeit als Eingabe.
     */
    public Fahrbahn(int zellen, int anzahlAutos, int maxGeschwindigkeit, double troedel) {

        this.anzahlZellen = zellen;
        this.maxGeschwindigkeit = maxGeschwindigkeit;
        this.troedel = troedel;

        autosZellen = new Auto[zellen];
        double div = (double) zellen / anzahlAutos;
        int anzahlAutosGrosserAbstand = zellen % anzahlAutos;
        int anzahlAutosKleinerAbstand = anzahlAutos - anzahlAutosGrosserAbstand;
        int abstandAbgerundet = (int) Math.floor(div);
        int abstandAufgerundet = (int) Math.ceil(div);

        int index = 0;
        for (int i = 0; i < anzahlAutosGrosserAbstand; i++) {
            autosZellen[index] = new Auto(maxGeschwindigkeit);
            index += abstandAufgerundet;
        }

        for (int i = 0; i < anzahlAutosKleinerAbstand; i++) {
            autosZellen[index] = new Auto(maxGeschwindigkeit);
            index += abstandAbgerundet;
        }

    }

    /**
     * Zeichnet die Zellen. Zahlen(Geschwindigkeit): für die Plätze, in denen es ein
     * Auto gibt. Unterstrich: für die Plätze, in denen es kein Auto gibt.
     */
    public void ausgeben() {
        for (int i = 0; i < autosZellen.length; i++) {
            if (autosZellen[i] == null) {
                System.out.print("_ ");
            } else {
                System.out.print(autosZellen[i] + " ");
            }
        }

        System.out.println();
    }

    /**
     * rechnet der Abstand zwischen zwei Autos.
     *
     * @return count: anzahl Zellen zwischen zwei Autos.
     */
    public int abstand2Autos(int autoIndex) {
        int count = 0;
        int i = (autoIndex + 1) % anzahlZellen;

        while (autosZellen[i] == null) {
            count++;
            i = (i + 1) % anzahlZellen;
        }

        return count;
    }

    /**
     * Die Regeln.
     */
    public void update() {

        int i = 0;
        while (i < anzahlZellen) {
            Auto auto = autosZellen[i];
            if (auto == null) {
                i++;
                continue;
            }
            // Regel 1 erh�he Geschwindigkeit
            int aktuelleGeschwindigkeit = auto.getSpeed();
            if (aktuelleGeschwindigkeit < maxGeschwindigkeit) {
                auto.setSpeed(++aktuelleGeschwindigkeit);
            }

            // Regel 2
            int anzahlFreieZellen = abstand2Autos(i);
            if (aktuelleGeschwindigkeit > anzahlFreieZellen) {
                aktuelleGeschwindigkeit = anzahlFreieZellen;
                auto.setSpeed(aktuelleGeschwindigkeit);
            }

            // Regel 3
            double random = Math.random();
            if (random < troedel && aktuelleGeschwindigkeit > 0) {
                auto.setSpeed(--aktuelleGeschwindigkeit);
            }

            // Regel 4
            int neuePosition = (i + aktuelleGeschwindigkeit) % anzahlZellen;
            autosZellen[neuePosition] = autosZellen[i];
            if (aktuelleGeschwindigkeit != 0) {
                autosZellen[i] = null;
            }
            i += (aktuelleGeschwindigkeit + 1);
        }
    }
}
