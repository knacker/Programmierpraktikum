//@author maximilian raspe
public class Zoo {
    public static void main(String[] args) {
        Tier[] viechaz = new Tier[4];	//erstellt array mit tieren
		//füllt array mit neuen tieren und führt diesen aus
        viechaz[0] = new Elefant("Justus");	
        System.out.println(viechaz[0]);
        viechaz[0].schreien();
        if (viechaz[0].getArt() == "Elefant") new Elefant().stampfen();
        System.out.println();
        viechaz[1] = new AfrikanischerElefant("Justyn");
        System.out.println(viechaz[1]);
        viechaz[1].schreien();
        if(viechaz[1].getArt() == "Afrikanischer Elefant") {
            new Elefant().stampfen();
        }
        System.out.println();
        viechaz[2] = new Wolf("Erik");
        System.out.println(viechaz[2]);
        viechaz[2].schreien();
        System.out.println();
        viechaz[3] = new Loewe("Lobo");
        System.out.println(viechaz[3]);
        viechaz[3].schreien();
        if (viechaz[3].getArt() == "Löwe") System.out.println("Er ist der König der Tiere");


    }

}
