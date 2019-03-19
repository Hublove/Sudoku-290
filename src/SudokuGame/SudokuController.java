package SudokuGame;

import java.io.FileNotFoundException;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
/**
 * The SudokuController class  is a child class of Controller and is responsible for handling key and mouse events for the Controller.
 * This class is also responsible for directly updating the model and setting new values for the game based on user input.  
 */
public class SudokuController extends Controller{
	long startTime = 0;
	/**
	 * The builder function accepts a view that the user should have control over and calls Controllers builder function to store it.
	 * @param view a view object that the user should see and have control over.
	 */
	public SudokuController(View view) {
		super(view);
		startTime = view.timeCounter;
	}
	/**
	 * This function is responsible for highliting the box selected by a user based on where the user clicked. 
	 * @param x the x coordinate where the user clicked.
	 * @param y the y coordinate where the uer clicked.
	 * @return 0 if user selected the box, 1 of user deselected the box, 3 if the user clicked the out of bounds and 2 id the user clicked inside of the game.
	 */
	public int updateEdit(int x, int y) {
		if (x >= 0 && x < 9 && y >= 0 && y < 9) {
			if (view.model.board.getNum(x, y) < 0) {
				if (view.model.isEditing) {
					view.numBackView[view.model.editIndex[0]][view.model.editIndex[1]].setImage(View.numBackImage);
					if (view.model.editIndex[0] == x && view.model.editIndex[1] == y) {
						view.model.isEditing = false;
						return 1;
					}
				}
				view.model.isEditing = true;
				view.model.editIndex[0] = x;
				view.model.editIndex[1] = y;
				view.numBackView[view.model.editIndex[0]][view.model.editIndex[1]].setImage(View.numBackSelImage);
				return 0;
			}
			return 3;
		}	
		return 2;
	}
	/**
	 * This function checks if the box is selectable, can be changed by the user and edits selects it.
	 * @param way the direction the user moves towards on the board.
	 */
	public void tryUpdate(int way) {
		int x = view.model.editIndex[0];
		int y = view.model.editIndex[1];
		do{
			switch(way){
			case 0:
				 y --;
				break;
			case 1:
				y ++;
				break;
			case 2:
				x --;
				break;
			case 3:
				x ++;
				break;
			}
		} while (updateEdit(x,y) == 3);
	}
	/**
	 * Instructions to make a box editable if its within bounds and sends the coordinates to updateEdit to check if the box is selectable.
	 */
	public void mousePressed(MouseEvent e) {
		double x = (e.getX() - 50);
		double y = (e.getY() - 50);
		
		if (x < 540 && y < 540 && x % 60 > 5 && x % 60 < 55 && y % 60 > 5 && y % 60 < 55) {
			updateEdit(((int)x) / 60, ((int)y) / 60);
		}else {
			for(int i = 0; i < ButtonPanel.BUTTONNUM; i ++) {
				if (view.buttonPanel.select[i]) {
					switch(i) {
					case 0:
						try {
							view.stage.setScene(view.initGameScene());
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
						break;
					case 1:
						boolean isWin = view.model.isGameSolved();
						System.out.println(isWin);
						break;
					case 2:
						view.stage.setScene(view.initInstructionScene(view.stage));
						break;
					}
				}
			}
		}
		
		
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		double x = (e.getX());
		double y = (e.getY());
		
		for (int i = 0; i < ButtonPanel.BUTTONNUM; i ++) {
			if (x > 680 && y < 80 + 80 * i + 65 && x < 810 && y > 80 + 80 * i) {
				view.buttonPanel.selectButton(i);
			}else {
				view.buttonPanel.leaveButton(i);
			}
		}
	}
/**
 * Instructions for keyboard buttons the user can use to control the game. 	
 */
	public void keyPressed(KeyEvent event) {
		if (view.model.isEditing) {
			switch (event.getCode()) {
			case NUMPAD1:
			case DIGIT1:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 1);
				break;
			case NUMPAD2:
			case DIGIT2:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 2);
				break;
			case NUMPAD3:
			case DIGIT3:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 3);
				break;
			case NUMPAD4:
			case DIGIT4:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 4);
				break;
			case NUMPAD5:
			case DIGIT5:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 5);
				break;
			case NUMPAD6:
			case DIGIT6:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 6);
				break;
			case NUMPAD7:
			case DIGIT7:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 7);
				break;
			case NUMPAD8:
			case DIGIT8:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 8);
				break;
			case NUMPAD9:
			case DIGIT9:
				view.model.board.setUserNum(view.model.editIndex[0], view.model.editIndex[1], 9);
				break;
			case UP:
			case W:
				tryUpdate(0);
				break;
			case DOWN:
			case S:
				tryUpdate(1);
				break;
			case LEFT:
			case A:
				tryUpdate(2);
				break;
			case RIGHT:
			case D:
				tryUpdate(3);
				break;
			default:
				break;
			}
			view.updateUserNum(view.model.editIndex[0], view.model.editIndex[1]);
		}
	}
	/**
	 * This function is responsible for updating how long the user has been playing the game for.
	 * It shows the timer in minutes and seconds.
	 * This function also rotates the gear on the board
	 */
	public void updateTimer() {
		int sec = (int)((view.timeCounter - this.startTime) % 60);
		int min = (int)((view.timeCounter - this.startTime) / 60);
		String timeS = "";
		if (min < 10) {
			timeS += "0" + min;
		}else if (min < 100){
			timeS += min;
		}else {
			timeS += "99";
		}
		
		if (sec < 10) {
			timeS += ":0" + sec;
		}else{
			timeS += ":" + sec;
		}
		view.timeText.setText(timeS);
		view.gearView.setRotate(view.gearView.getRotate() + 0.2);
		view.buttonPanel.updateAnimation();
	}
}
