package SudokuGame;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * The Controller class is an abstract class that contains instructions based on each user input.
 * Implementation for selected functions are in the main SudokuController class.
 */
public abstract class Controller {
	View view;
	/**
	 * The builder function accepts the current view of the game and can be used by all of Controllers child classes.
	 * @param view the current view the user has control over.
	 */
	Controller(View view){
		this.view = view;
	}
	public void keyPressed(KeyEvent event) {}
	public void keyReleased(KeyEvent event) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void updateTimer() {}

}
