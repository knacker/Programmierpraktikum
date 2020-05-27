//@author maximilian raspe
package snake;

public class Body {

    private int x;
    private int y;

    //constructor der x und y übergeben bekommt und dann x,y setzt
    public Body(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //getter und setter methoden für x und y
    public int getPositionX() {
        return x;
    }
    public int getPositionY() {
        return y;
    }
    public void setPositionX(int x) {
        this.x = x;
    }
    public void setPositionY(int y) {
       this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {

        if(!(obj instanceof Body)) {
            return false;
        }
        Body m = (Body) obj;
        if(this.x != m.x) {
            return false;
        }
        if(this.y != m.y) {
            return false;
        }
       return true;
    }
}
