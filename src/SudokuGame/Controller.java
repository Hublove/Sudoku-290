package SudokuGame;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * abstract class for controllers
 *
 */
public abstract class Controller {
	View view;
	
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