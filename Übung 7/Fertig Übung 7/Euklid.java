package com.company;
import java.util.Scanner;

public class Euklid {

public static int a;
public static int b;

    public static void main(String[] args) {

        Scanner zahlen = new Scanner(System.in);
        System.out.println("Bitte Zahl a eingeben");
        a = zahlen.nextInt();
        System.out.println("Bitte Zahl b eingeben");
        b = zahlen.nextInt();
        zahlen.close();

        ggT(a,b);
    }
    public static void ggT(int a, int b) {
        if (a == b) {   // wenn a = b, dann wird der ggT ausgegeben
            System.out.println("ggT : " + a);
            System.exit(0);
        }
        if(a > b) { //wenn a > b, dann wird subtrahiert und mit den neuen werten ggT aufgerufen
            a = a - b;
            ggT(a,b);
        }
        if(a < b) { //wenn b > a, dann wird subtrahiert und mit den neuen werten ggT aufgerufen
            b = b - a;
            ggT(a,b);
        }
    }
}
