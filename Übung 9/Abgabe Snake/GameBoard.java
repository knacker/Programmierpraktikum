/**
 * 
 *///@author maximilian raspe
package snake;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * @author Sven Loeffler
 * @date 04.12.2018
 * @version 1.0
 */
public class GameBoard {

	private static Body appleBody;
	private static ISnake snake;
	private GameBoard board;

	/**
	 * The timer which handle the inputs.
	 */
	private static Timer timer;
	private static int time = 100;

	/**
	 * Creates a new GameBoard. For this, a new Snake is created with this
	 * GameBoard as input, then a new appleBody is created and the apple is set.
	 */
	public GameBoard() {
		Console.setBackground(Color.black);	//malt konsole und generiert apfel
		Console.setForeground(Color.white);
		appleBody = new Body(5, 7);
		drawApple();
		drawSnake();

	}

	/**
	 * Initialize the timer and start the game.
	 */
	public void startGame() {
		timer = new Timer(time, new ActionListener() {

			@Override
			// every time a timer interrupt appears the snake moves
			public void actionPerformed(ActionEvent e) {
				Console.displayOff();
				if (!snake.move()) {
					gameOver();
				} else {
					Console.setForeground(Color.BLACK);
					Console.setBackground(Color.BLACK);
					Console.clear();
					drawSnake();
					drawApple();
				}
				Console.displayOn();
			}
		});

		// start the timer
		timer.setCoalesce(true);
		timer.start();

	}

	/**
	 * Listen to the keyboard and set the new direction.
	 * 
	 * @param c
	 *            The new direction.
	 */
	public static void listen(char c) {
		snake.setDir(c);
	}

	/**
	 * Draw the "Game Over" screen with current score: snake.length - initial
	 * length of snake
	 */
	private static void gameOver() {
		timer.stop();
		Console.displayOff();
		Console.clear();
		int x = 10;
		int y = 6;
		Console.gotoXY(x, y);
		Console.setBackground(Color.WHITE);
		Console.write("   ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("    ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write("    ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("   ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");

		x = 10;
		y++;
		Console.gotoXY(x, y);
		Console.write("   ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("    ");

		y++;

		x = 10;
		y++;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("    ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write("   ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write("   ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write("    ");

		x = 9;
		y++;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 2;
		Console.gotoXY(x, y);
		Console.write(" ");

		x = 10;
		y++;
		Console.gotoXY(x, y);
		Console.write("  ");
		x = x + 6;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 4;
		Console.gotoXY(x, y);
		Console.write("    ");
		x = x + 5;
		Console.gotoXY(x, y);
		Console.write(" ");
		x = x + 3;
		Console.gotoXY(x, y);
		Console.write(" ");

		y++;
		y++;
		y++;
		x = 10;
		Console.gotoXY(x, y);
		Console.setForeground(Color.BLACK);
		Console.write("Your score:" + (snake.getLength() - ISnake.DEFAULT_START_LENGTH));

		Console.displayOn();
		Console.displayOff();
	}

	/**
	 * @return the appleBody
	 */
	public Body getAppleBody() {
		return appleBody;
	}

	/**
	 * Draw the snake based on values in snake.body (LinkedList).
	 */
	private static void drawSnake() {
		Console.setForeground(Color.DARK_GRAY);
		Console.setBackground(Color.GREEN);
		for (int i = 0; i < ISnake.body.size(); i++) {
			int x = ISnake.body.get(i).getPositionX();
			int y = ISnake.body.get(i).getPositionY();
			Console.gotoXY(x, y);
			Console.write("~");
		}
	}

	/**
	 * Draw the apple and the instructions.
	 */
	private static void drawApple() {
		Console.setForeground(Color.WHITE);
		Console.setBackground(Color.BLACK);
		Console.gotoXY(0, 0);
		Console.write("w: up, a: left, s: down, d: right");
		Console.setBackground(Color.RED);
		Console.setForeground(Color.GREEN);
		Console.gotoXY(appleBody.getPositionX(), appleBody.getPositionY());
		Console.write("O");
		Console.setForeground(Color.WHITE);
		Console.setBackground(Color.BLACK);
	}

	/**
	 * Every time the snake eats an apple, a new apple has to be set.
	 */
	public void setApple() {
		// apple must fit in the console columns and rows
		double x = -1;
		double y = -1;

		do {
			x = Math.round(Math.random() * Console.DEFAULT_COLS);
			y = Math.round(Math.random() * (Console.DEFAULT_ROWS - 2)) + 1;
			appleBody.setPositionX((int) x);
			appleBody.setPositionY((int) y);
		} while (ISnake.body.contains(appleBody) || (appleBody.getPositionX() == Console.DEFAULT_COLS - 1
				&& appleBody.getPositionY() == Console.DEFAULT_ROWS - 1));

		drawApple();
	}
}
