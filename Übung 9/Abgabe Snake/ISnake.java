/**@author maximilian raspe
 * 
 */
package snake;

import java.util.LinkedList;

/**
 * @author Viktoria, Sven
 * @date 03.12.2018
 * @version 1.0
 *
 *          The snake that snakes over the gameboard with attributes length,
 *          direction and body which is an ArrayList of snake.Body elements.
 */
public interface ISnake {

	/**
	 * Possible directions of the snake: go up
	 */
	final static char GO_UP = 'w';

	/**
	 * Possible directions of the snake: go down
	 */
	final static char GO_DOWN = 's';

	/**
	 * Possible directions of the snake: go left
	 */
	final static char GO_LEFT = 'a';

	/**
	 * Possible directions of the snake: go right
	 */
	final static char GO_RIGHT = 'd';

	/**
	 * The default x and y position of a body cell.
	 */
	final static int DEFAULT_BODY_POSITION = 0;

	/**
	 * The defulat start length of the snake.
	 */
	final static int DEFAULT_START_LENGTH = 3;

	/**
	 * The body list contains body elements which have knowledge about there x
	 * and y position.
	 */
	LinkedList<Body> body = new LinkedList<Body>();

	/**
	 * Check if the given char is in { GO_UP, GO_DOWN, GO_LEFT, GO_RIGHT} then
	 * it set this.dir to the given value otherwise do nothing.
	 * 
	 * @param dir
	 *            The new direction of the snake.
	 */
	public void setDir(char dir);

	/**
	 * @return The direction of the snake.
	 */
	public char getDir();

	/**
	 * Returns true if the position of the head of the snake is equal to the
	 * position of the apple from the game board.
	 * 
	 * @return true if the head of the snake have the same position like the
	 *         apple otherwise false.
	 */
	public boolean isEating();

	/**
	 * Returns the number of body cells.
	 * 
	 * @return The number of body cells.
	 */
	public int getLength();

	/**
	 * Change the coordinates of the first body cell to old coordinates plus the
	 * step into its direction. Set the coordinates of every other cell to the
	 * coordinates of the previous body cell.
	 * 
	 * Call the isEating method and add a body cell to the body if necessary and
	 * set a new apple if necessary.
	 * 
	 * Check if the snake is self eating or leave the board.
	 * 
	 * @return True if the snake does not leave the game or is self eating
	 *         otherwise false.
	 */
	public boolean move();

	/**
	 * Check if the snake is eating itself. A snake is eating itself, if the
	 * first body position is equal to any other body position.
	 * 
	 * @return True if the snake eat itself, false otherwise.
	 */
	public boolean isSelfEating();

	/**
	 * Check if the snake leaves the board or not.
	 * 
	 * @return True if the snake leaves the board otherwise false.
	 */
	public boolean leavesTheBoard();

}
