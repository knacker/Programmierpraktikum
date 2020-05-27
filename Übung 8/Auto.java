//@author maximilian raspe
public class Auto {

    private int speed;

    public int getSpeed() {
        return this.speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Auto(int maxSpeed) {
        this.speed = maxSpeed;
    }
    @Override
    public String toString() {
        return Integer.toString(speed);
    }
}
