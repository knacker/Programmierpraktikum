//@author maximilian raspe
import java.util.Scanner;
public class VierGewinnt {

    public static boolean spieler = true; //true = spieler 1, false = spieler 2
    public static char feld[][] = new char[7][6];
    public static boolean fertig = false;

    public static void main(String[] args) {

        int position = 0;

        feldVorbereiten();

        while(true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Spieler " + spieler + " ist an der Reihe(true = spieler 1, false = spieler 2" );

            //programm wird bei einer anderen eingabe als einem int beendet
            if(scan.hasNextInt()) {
                position = scan.nextInt();
            } else System.exit(1);

            //abbruchbedingung, prüfen ob zahl zwischen 0 und 6 liegt und ob die reihe voll ist
            if(position == 0 || position == 1 || position == 2 || position == 3 || position == 4 || position == 5 || position == 6) {
                int counter = 0;
                for (int j = 0; j < 6; j++) {
                    if (feld[position][j] == 'o' || feld[position][j] == 'x') {
                        counter++;
                        if (counter >= 6) { //wenn reihe voll ist, solange neu einlesen bis ein nutzbarer wert rauskommt
                            boolean neuEingeben = false;

                            while (neuEingeben == false) {
                                System.out.println("Bitte neue eingabe");
                                position = scan.nextInt();
                                counter = 0;
                                for (int k = 0; k < 6; k++) {
                                    if (feld[position][k] == 'o' || feld[position][k] == 'x') {
                                        counter++;
                                    }
                                }
                                if(counter < 6) {
                                    neuEingeben = true;
                                }
                            }
                        }
                    }
                }

            } else {    //falls die zahl ungleich 0-6 sein sollte, solange einlesen bis das der fall ist
                boolean neuEingeben = false;
                while (neuEingeben == false) {
                    System.out.println("Bitte neue eingabe");
                    position = scan.nextInt();
                    int counter = 0;
                    for (int k = 0; k < 6 && position <= 6 && position >= 0; k++) {
                        if (feld[position][k] == 'o' || feld[position][k] == 'x') {
                            counter++;
                        }
                        if(counter < 6 && position <= 6 && position >= 0) {
                            neuEingeben = true;
                        }

                    }
                }
            }
            setzeStein(spieler, position, feld);
            if(spieler == true) {
                spieler = false;
            } else spieler = true;
        }

    }
    //setzt die steine im array, je nach eingabe und welcher spieler dran ist
    private static void setzeStein(boolean spieler1, int position, char [][] field) {
        if(spieler1 == true) {
            for(int i = 0; i < 6; i++) {
                if(field[position][i] == 'x' || field[position][i] == 'o') {
                    field[position][i - 1] = 'x';
                    break;
                }
                else if(i == 5) {
                    field[position][i] = 'x';
                }
            }
        }
        if(spieler1 == false) {
            for(int i = 0; i < 6; i++) {
                if(field[position][i] == 'x' || field[position][i] == 'o') {
                    field[position][i - 1] = 'o';
                    break;
                }
                else if(i == 5) {
                    field[position][i] = 'o';
                }
            }
        }
        maleFeld(field);
    }
    //malt das feld mithilfe der eingabe
    private static void maleFeld(char[][] field) {
        System.out.flush();
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                System.out.print(field[j][i]);
            }
            System.out.println();
        }
    }
    //bereitet das feld vor dem spiel vor, damit es wie ein "feld" aussieht
    private static void feldVorbereiten() {
        for(int i = 0; i < 6; i++) {
            for(int j = 0; j < 7; j++) {
                feld[j][i] = ' ';
            }
        }
    }
}