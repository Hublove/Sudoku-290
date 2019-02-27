package SudokuGame;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class SudokuController extends Controller{
	long startTime = 0;
	
	public SudokuController(View view) {
		super(view);
		startTime = view.timeCounter;
	}
	
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
	
	public void mousePressed(MouseEvent e) {
		double x = (e.getX() - 50);
		double y = (e.getY() - 50);
		
		if (x < 540 && y < 540 && x % 60 > 5 && x % 60 < 55 && y % 60 > 5 && y % 60 < 55) {
			updateEdit(((int)x) / 60, ((int)y) / 60);
		}
	}

	
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
	}
}