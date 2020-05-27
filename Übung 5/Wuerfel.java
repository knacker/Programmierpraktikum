import java.util.Arrays;

//@author Maximilian Raspe

public class Wuerfel {

	public static void main(String[] args) {
		
		int[] zahlen = new int[6000000];
		int [] ergebnis = new int[6];
		
		boolean col = false;
		
		for(int i = 0; i < zahlen.length; i++) {
			zahlen[i] = (int)(Math.random()* 6) + 1;	//generiert die würfelzahlen und prüft ob 1,2,3,4,5 oder 6 und zählt hoch
			if(zahlen[i] == 1) ergebnis[0] += 1;
			if(zahlen[i] == 2) ergebnis[1] += 1;
			if(zahlen[i] == 3) ergebnis[2] += 1;
			if(zahlen[i] == 4) ergebnis[3] += 1;
			if(zahlen[i] == 5) ergebnis[4] += 1;
			if(zahlen[i] == 6) ergebnis[5] += 1;
		}

		System.out.println("1" +"\t"+ "2" + "\t" + "3" + "\t" +  "4" + "\t"  + "5" + "\t" + "6");
		System.out.println("----------------------------------------------");
		System.out.println( ergebnis[0] + "\t" + ergebnis[1] + "\t" + ergebnis[2]  + "\t" + ergebnis[3]  + "\t" +  ergebnis[4] + "\t" +  ergebnis[5]);

		

	}
}
