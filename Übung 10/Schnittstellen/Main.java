//@author maximilian raspe
public class Main {
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk("Kiosk");
        kiosk.addKioskInhalt(new Kasse("Peter"));
        kiosk.addKioskInhalt(new EBookReader("Sony"));
        kiosk.addKioskInhalt(new Zeitung("Wochenblatt"));
        System.out.println(kiosk);
    }
}
