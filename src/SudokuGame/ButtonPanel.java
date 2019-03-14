package SudokuGame;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * contain information about button panel
 */
public class ButtonPanel {
	static final int BUTTONNUM = 3, MAXLENGTH = 70, CHANGESPEED = 10;
	static final Image buttonBack = new Image("/image/buttonBack.png"), 
			textBlackImage[] = {new Image("/image/restartB.png"),
					new Image("/image/checkB.png"),
					new Image("/image/howB.png")};
	
	double animationCounter[];
	ImageView buttonView[], textView[], select;
	
	Group views;
	
	/**
	 * create a new ButtonPanal
	 * @param mainView the Group will contain all buttons
	 */
	public ButtonPanel(Group mainView) {
		animationCounter = new double[BUTTONNUM];
		buttonView = new ImageView[BUTTONNUM];
		textView = new ImageView[BUTTONNUM];
		select = null;
		views = new Group();
		mainView.getChildren().add(views);
		
		for (int i = 0; i < BUTTONNUM; i ++) {
			animationCounter[i] = 0;
			buttonView[i] = new ImageView(buttonBack);
			buttonView[i].setFitHeight(65);
			buttonView[i].setFitWidth(200);
			buttonView[i].relocate(680, 80 + 80 * i);
			views.getChildren().add(buttonView[i]);
			textView[i] = new ImageView(textBlackImage[i]);
			textView[i].relocate(800 - textBlackImage[i].getWidth(), 95 + 80 * i);
			views.getChildren().add(textView[i]);
		}
	}
	
	/**
	 * select the button at given index
	 * @param index the index of the button
	 */
	public void selectButton(int index) {
//		for (int i = 0; i < BUTTONNUM; i++) {
//			leaveButton(i);
//		}
		select = buttonView[index];
	}
	
	/**
	 * set select of the button to false at given index
	 * @param index the index of the button
	 */
	public void leaveButton() {
		select = null;
	}
	
	/**
	 * Update animation
	 */
	public void updateAnimation() {
		for (int i = 0; i < BUTTONNUM; i ++) {
			if (select == buttonView[i] && animationCounter[i] < MAXLENGTH) {
				animationCounter[i] += CHANGESPEED;
			}else if ( select != buttonView[i] && animationCounter[i] > 0) {
				animationCounter[i] -= CHANGESPEED;
			}
			buttonView[i].relocate(680 - animationCounter[i], 80 + 80 * i);
			textView[i].relocate(800 - textBlackImage[i].getWidth() - animationCounter[i], 95 + 80 * i);
		}
	}
}
