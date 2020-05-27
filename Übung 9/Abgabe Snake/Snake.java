//@author maximilian raspe
package snake;

public abstract class Snake implements ISnake {
    private char dir;
    private int length;
    private GameBoard board;
    private Body snake;
    /**
     * Creates a new Snake with default length in the middle of the Console.
     * Every body cell has the default position for x and y.
     *
     * The default direction should be GO_RIGHT.
     *
     * @param board
     * Set the board of the snake to board.
     */
    public Snake(GameBoard board) {
        for (int i = 0; i < DEFAULT_START_LENGTH; i++) {
            body.add(new Body(10, 10));
        }
        this.dir = GO_RIGHT;
        this.board = board;
    }
    //setter methode für die richtung und jeweiligen tastendruck
    @Override
    public void setDir(char dir) {
        if(dir == 'A') {
            this.dir = GO_LEFT;
        }
        if(dir == 'W') {
            this.dir = GO_UP;
        }
        if(dir == 'D') {
            this.dir = GO_RIGHT;
        }
        if(dir == 'S') {
            this.dir = GO_DOWN;
        }
    }
    //getter methode für direction
    @Override
    public char getDir() {
        return this.dir;
    }
    //länge der liste
    @Override
    public int getLength() {
        return body.size();
    }
    //prüft ob kopf der schlange an einem apfel ist
    @Override
    public boolean isEating() {
        if(snake.equals(board.getAppleBody())) {
            return true;

        }
        else return false;
    }

    @Override
    public boolean move() {

        int x = snake.getPositionX();
        int y = snake.getPositionY();

        if(isEating() == true) {
            body.addLast(snake);
            board.setApple();

        }
        if(isSelfEating() == true) {
            return false;
        }
        if(leavesTheBoard() == true) {
            return false;

        }
        if(getDir() == GO_LEFT) {
            snake.setPositionX(x - 1);
            ISnake.body.addLast(snake);
            ISnake.body.removeFirst();
        }
        if(getDir() == GO_RIGHT) {
            snake.setPositionX(x + 1);
            ISnake.body.addLast(snake);
            ISnake.body.removeFirst();

        }
        if(getDir() == GO_UP) {
            snake.setPositionY(y + 1);
            ISnake.body.addLast(snake);
            ISnake. body.removeFirst();

        }
        if(getDir() == GO_DOWN) {
           snake.setPositionY(y - 1);
           ISnake.body.addLast(snake);
           ISnake.body.removeFirst();

        }
        return true;
    }

    @Override
    public boolean leavesTheBoard() {
        if(snake.getPositionX() > 40) {
            return true;
        }
        if(snake.getPositionX() < 0) {
            return true;
        }
        if(snake.getPositionY() > 27) {
            return true;
        }
        if(snake.getPositionY() < 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isSelfEating() {
        for(int i = 1; i <= body.size(); i++) {
            if (ISnake.body.getFirst().equals(ISnake.body.get(i))) {
                return true;
            }
        }
        return false;
    }

}
