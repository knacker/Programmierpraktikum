//@author maximlian raspe
import java.awt.Color;
import java.util.Arrays;

public class Bundestagswahl {

	public static void main(String[] args) {
	
		boolean fertig = false;
		
		//überschrift
		Console.gotoXY(4, 2);
		Console.write("BUNDESTAGSWAHL");
		
		//zufallszahlen berechnen
		int resultGrüne = (int)(Math.random() * 50) + 1;
		int resultLinke = (int)(Math.random() * 50) + 1;
		int resultAndere = (int)(Math.random() * 50) + 1;
		int resultSPD = (int)(Math.random() * 50) + 1;
		int resultCDU = (int)(Math.random() * 50) + 1;
		int counter = 0; // counter zählt den fortschritt
		
		
		//namen vor strahlen
		Console.setForeground(java.awt.Color.blue);
		Console.gotoXY( 2, 5 );
		Console.write("CDU");
		
		Console.setForeground(java.awt.Color.red);
		Console.gotoXY( 2, 7 );
		Console.write("Linke");
		
		Console.setForeground(java.awt.Color.yellow);
		Console.gotoXY( 2, 9 );
		Console.write("Andere");
		
		Console.setForeground(java.awt.Color.green);
		Console.gotoXY( 2, 11 );
		Console.write("Grüne");
		
		Console.setForeground(java.awt.Color.white);
		Console.gotoXY( 2, 13 );
		Console.write("SPD");
		
		//sortiere array der größe nach
		int[] arr = {resultGrüne, resultLinke, resultAndere, resultSPD, resultCDU};
		Arrays.sort(arr);
		
		while (fertig == false) { 
			for(int i = 8; i < arr[0] + 8; i++) { //schleife für kleinste zahl, geht solange wieter, bis i > zahl an index 0 ist
				Console.setForeground(java.awt.Color.blue);
				Console.gotoXY( i + 1, 5 );
				Console.wait(25);
				Console.write("I ");
				Console.gotoXY(70, 5);
				Console.write(counter + "");
				
				Console.setForeground(Color.red);
				Console.gotoXY( i  + 1, 7 );
				Console.wait(25);
				Console.write("I");
				Console.gotoXY(70, 7);
				Console.write(counter + "");
				
				Console.setForeground(Color.yellow);
				Console.gotoXY( i  + 1, 9 );
				Console.wait(25);
				Console.write("I");
				Console.gotoXY(70, 9);
				Console.write(counter + "");
				
				Console.setForeground(Color.green);
				Console.gotoXY( i  + 1, 11 );
				Console.wait(25);
				Console.write("I");
				Console.gotoXY(70, 11);
				Console.write(counter + "");
				
				Console.setForeground(Color.white);
				Console.gotoXY( i  + 1, 13 );
				Console.wait(25);
				Console.write("I");
				Console.gotoXY(70, 13);
				Console.write(counter + "");
				counter++;
				
			}
			for(int i = counter + 8; counter + 8 < arr[1]; i++) {	//schleife für nächst größere zahl
				if(resultCDU >= arr[1]) {
					Console.setForeground(java.awt.Color.blue);
					Console.gotoXY(8 + counter + 1, 5 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 5);
					Console.write(counter + "");
				}
				if(resultLinke >= arr[1]) {
					Console.setForeground(java.awt.Color.red);
					Console.gotoXY( 8 +counter + 1, 7 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 7);
					Console.write(counter + "");
				}
				if(resultAndere >= arr[1]) {
					Console.setForeground(java.awt.Color.yellow);
					Console.gotoXY(8 + counter + 1, 9 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 9);
					Console.write(counter + "");
				}
				if(resultGrüne >= arr[1]) {
					Console.setForeground(java.awt.Color.green);
					Console.gotoXY( 8 + counter + 1, 11 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 11);
					Console.write(counter + "");
				}
				if(resultSPD >= arr[1]) {
					Console.setForeground(java.awt.Color.white);
					Console.gotoXY(8 + counter + 1, 13 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 13);
					Console.write(counter + "");
				}
				counter++;
			}
			for(int i = counter + 8; counter + 8 < arr[2]; i++) {	//schleife für nächst größere zahl
				if(resultCDU >= arr[2]) {
					Console.setForeground(java.awt.Color.blue);
					Console.gotoXY(8 + counter + 1, 5 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 5);
					Console.write(counter + "");
				}
				if(resultLinke >= arr[2]) {
					Console.setForeground(java.awt.Color.red);
					Console.gotoXY(8 + counter + 1, 7 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 7);
					Console.write(counter + "");
				}
				if(resultAndere >= arr[2]) {
					Console.setForeground(java.awt.Color.yellow);
					Console.gotoXY(8 + counter + 1, 9 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 9);
					Console.write(counter + "");
				}
				if(resultGrüne >= arr[2]) {
					Console.setForeground(java.awt.Color.green);
					Console.gotoXY(8 + counter + 1, 11 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 11);
					Console.write(counter + "");
				}
				if(resultSPD >= arr[2]) {
					Console.setForeground(java.awt.Color.white);
					Console.gotoXY( 8 + counter + 1, 13 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 13);
					Console.write(counter + "");
				}
				counter++;
			}
			
			for(int i = counter + 8; counter + 8 < arr[3]; i++) {	//schleife für nächst größere zahl
				if(resultCDU >= arr[3]) {
					Console.setForeground(java.awt.Color.blue);
					Console.gotoXY(8 + counter + 1, 5 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 5);
					Console.write(counter + "");
				}
				if(resultLinke >= arr[3]) {
					Console.setForeground(java.awt.Color.red);
					Console.gotoXY(8 + counter + 1, 7 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 7);
					Console.write(counter + "");
				}
				if(resultAndere >= arr[3]) {
					Console.setForeground(java.awt.Color.yellow);
					Console.gotoXY(8 + counter + 1, 9 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 9);
					Console.write(counter + "");
				}
				if(resultGrüne >= arr[3]) {
					Console.setForeground(java.awt.Color.green);
					Console.gotoXY(8 + counter + 1, 11 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 11);
					Console.write(counter + "");
				}
				if(resultSPD >= arr[3]) {
					Console.setForeground(java.awt.Color.white);
					Console.gotoXY(8 + counter + 1, 13 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 13);
					Console.write(counter + "");
				}
				counter++;
			}
			for(int i = counter + 8; counter + 8 < arr[4]; i++) {	//schleife für größte zahl
				if(resultCDU >= arr[4]) {
					Console.setForeground(java.awt.Color.blue);
					Console.gotoXY(8 + counter + 1, 5 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 5);
					Console.write(counter + "");
				}
				if(resultLinke >= arr[4]) {
					Console.setForeground(java.awt.Color.red);
					Console.gotoXY( 8 + counter + 1, 7 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 7);
					Console.write(counter + "");
				}
				if(resultAndere >= arr[4]) {
					Console.setForeground(java.awt.Color.yellow);
					Console.gotoXY(8 + counter + 1, 9 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 9);
					Console.write(counter + "");
				}
				if(resultGrüne >= arr[4]) {
					Console.setForeground(java.awt.Color.green);
					Console.gotoXY(8 + counter + 1, 11 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 11);
					Console.write(counter + "");
				}
				if(resultSPD >= arr[4]) {
					Console.setForeground(java.awt.Color.white);
					Console.gotoXY(8 + counter + 1, 13 );
					Console.wait(25);
					Console.write("I ");
					Console.gotoXY(70, 13);
					Console.write(counter + "");
				}
				counter++;
			}
			fertig = true;
			
			
			
		}

		if(arr[4] == resultCDU) {
			Console.gotoXY(5, 20);
			Console.write("Gewinner ist CDU");
		}
		if(arr[4] == resultLinke) {
			Console.gotoXY(5, 20);
			Console.write("Gewinner ist Linke");
		}
		if(arr[4] == resultAndere) {
			Console.gotoXY(5, 20);
			Console.write("Gewinner ist Andere");
		}
		if(arr[4] == resultGrüne) {
			Console.gotoXY(5, 20);
			Console.write("Gewinner ist Grüne");
		}
		if(arr[4] == resultSPD) {
			Console.gotoXY(5, 20);
			Console.write("Gewinner ist SPD");
		}
	}
}