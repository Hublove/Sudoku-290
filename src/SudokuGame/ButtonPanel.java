package SudokuGame;

import java.util.ArrayList;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * contain information about button panel
 */
public class ButtonPanel {
	static final int BUTTONNUM = 3, MAXLENGTH = 100, CHANGESPEED = 5;
	static final Image buttonBack = new Image("/image/bordBack.png"), 
			textBlackImage[] = {new Image("/image/num/0c.png"),
					new Image("/image/num/0c.png"),
					new Image("/image/num/0c.png")},
			textColorImage[] = {new Image("/image/num/0d.png"),
					new Image("/image/num/0d.png"),
					new Image("/image/num/0d.png")};
	
	double animationCounter[];
	ImageView buttonView[], textView[];
	boolean select[];
	
	Group views;
	
	/**
	 * create a new ButtonPanal
	 * @param mainView the Group will contain all buttons
	 */
	public ButtonPanel(Group mainView) {
		animationCounter = new double[BUTTONNUM];
		buttonView = new ImageView[BUTTONNUM];
		textView = new ImageView[BUTTONNUM];
		select = new boolean[BUTTONNUM];
		views = new Group();
		mainView.getChildren().add(views);
		
		for (int i = 0; i < BUTTONNUM; i ++) {
			animationCounter[i] = 0;
			buttonView[i] = new ImageView();
			buttonView[i].relocate(80 + 80 * i, 610);
			views.getChildren().add(buttonView[i]);
			textView[i] = new ImageView(textBlackImage[i]);
			textView[i].relocate(80 + 80 * i, 800 - textView[i].getFitWidth());
			views.getChildren().add(textView[i]);
			select[i] = false;
		}
	}
	
	/**
	 * select the button at given index
	 * @param index the index of the button
	 */
	public void selectButton(int index) {
		select[index] = true;
		textView[index].setImage(textColorImage[index]);
	}
	
	/**
	 * set select of the button to false at given index
	 * @param index the index of the button
	 */
	public void leaveButton(int index) {
		select[index] = false;
		textView[index].setImage(textBlackImage[index]);
	}
	
	/**
	 * Update animation
	 */
	public void updateAnimation() {
		for (int i = 0; i < BUTTONNUM; i ++) {
			if (select[i] && animationCounter[i] < MAXLENGTH) {
				animationCounter[i] += CHANGESPEED;
			}else if ( !select[i] && animationCounter[i] > 0) {
				animationCounter[i] -= CHANGESPEED;
			}
			buttonView[i].relocate(80 + 80 * i, 610 - animationCounter[i]);
			textView[i].relocate(80 + 80 * i, 800 - textView[i].getFitWidth() - animationCounter[i]);
		}
	}
}
