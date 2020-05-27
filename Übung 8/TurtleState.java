//@author Maximlian Raspe
public class TurtleState {

    private double x;
    private double y;
    private double angle;
    private boolean down;

    public double getX() {
        return this.x;
    }
    public double getY() {
        return this.y;
    }
    public double getAngle() {
        return this.angle;
    }
    public boolean getDown() {
        return this.down;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public void setDown(boolean down) {
        this.down = down;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
