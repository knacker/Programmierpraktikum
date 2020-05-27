//@author maximilian raspe
import java.util.Scanner;
public class Potenzen {
   public static void main (String[] args) {

         Scanner scan = new Scanner(System.in);
         System.out.println("Zahl a eingeben");
         double a = scan.nextDouble();
         System.out.println("Zahl b eingeben");
         double b = scan.nextDouble();
       int x = (int)Math.floor(Math.random() * 80) + 1;
         potenzieren(a,b);

   }

   public static void potenzieren(double a, double b) {
        int counter = 0;
        double zwischenergebnis = 0;
        double ergebnis = 1;
        boolean fertig = false;
        while(counter < b - 1) {    //prüft ob zähler schon die anzahl der durchläufe der potenz erreicht hat
            if(zwischenergebnis == 0) {
                zwischenergebnis = multiplizieren(a, a);
                counter++;
            }
            ergebnis = multiplizieren(zwischenergebnis, a);
            zwischenergebnis = ergebnis;
            counter++;
        }
        System.out.println(ergebnis);
   }
   public static double multiplizieren(double a, double b) {
       double sum = 0;
       if(a > b) {  //wenn a > b, dann wird so oft addiert, bis das ergebnis erreicht wurde, das selbe gilt für die unteren ifs
           for(int i = 0; i < a; i++) {
               sum = sum + b;
           }
           return sum;
       }
       if(b > a) {
           for (int i = 0; i < b; i++) {
                sum = sum + a;
           }
           return sum;
       }
       if(b == a) {
           for (int i = 0; i < b; i++) {
               sum = sum + a;
           }
           return sum;
       }
       return sum;
   }
}
