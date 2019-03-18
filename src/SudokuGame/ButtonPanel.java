package SudokuGame;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Contains the information about the Button Panel. 
 */
public class ButtonPanel {
	
	//BUTTONNUM - number of buttons
	//MAXLENGTH - how far the button goes out
	//CHANGESPEED - how fast the button moves
	static final int BUTTONNUM = 3, MAXLENGTH = 70, CHANGESPEED = 10;
	
	//Images for buttons
	static final Image buttonBack = new Image("/image/buttonBack.png"), 
			textBlackImage[] = {new Image("/image/restartB.png"),
					new Image("/image/checkB.png"),
					new Image("/image/howB.png")};
	
	
	double animationCounter[];
	ImageView buttonView[], textView[];
	boolean select[];
	
	Group views;
	
	/**
	 * Initializes a ButtonPanel class.
	 * @param mainView the Group will contain all buttons
	 */
	public ButtonPanel(Group mainView) {
		animationCounter = new double[BUTTONNUM];
		buttonView = new ImageView[BUTTONNUM];
		textView = new ImageView[BUTTONNUM];
		select = new boolean[BUTTONNUM];
		views = new Group();
		mainView.getChildren().add(views);
		
		for (int i = 0; i < BUTTONNUM; i ++) {//init button views
			animationCounter[i] = 0;
			buttonView[i] = new ImageView(buttonBack);
			buttonView[i].setFitHeight(65);
			buttonView[i].setFitWidth(200);
			buttonView[i].relocate(680, 80 + 80 * i);
			views.getChildren().add(buttonView[i]);
			textView[i] = new ImageView(textBlackImage[i]);
			textView[i].relocate(800 - textBlackImage[i].getWidth(), 95 + 80 * i);
			views.getChildren().add(textView[i]);
			select[i] = false;
		}
	}
	
	/**
	 * Select the button at the given index. 
	 * @param index the index of the button
	 */
	public void selectButton(int index) {
		select[index] = true;
	}
	
	/**
	 * Set button's select to false at the given index.
	 * @param index the index of the button
	 */
	public void leaveButton(int index) {
		select[index] = false;
	}
	
	/**
	 * Updates animation of ButtonPanel. 
	 */
	public void updateAnimation() {
		for (int i = 0; i < BUTTONNUM; i ++) {
			if (select[i] && animationCounter[i] < MAXLENGTH) {
				animationCounter[i] += CHANGESPEED;
			}else if ( !select[i] && animationCounter[i] > 0) {
				animationCounter[i] -= CHANGESPEED;
			}
			buttonView[i].relocate(680 - animationCounter[i], 80 + 80 * i);
			textView[i].relocate(800 - textBlackImage[i].getWidth() - animationCounter[i], 95 + 80 * i);
		}
	}
}
