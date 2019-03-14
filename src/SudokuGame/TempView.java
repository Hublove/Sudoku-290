/**
 * 
 * 
 * @author Seungmin Baek
 */

package SudokuGame;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;
import javafx.animation.AnimationTimer;

public class TempView extends Application{

	//Images for Instruction Screen
	Image startImage = new Image("/image/startscreen.png"),
			startBImage = new Image("/image/playB.png"),
			helpBImage = new Image("/image/helpB.png"),
			instructionImage = new Image("/image/instructionscreen.png"),
			boardImage = new Image("/image/bordBack.png");

	int screen_state = 0;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}

	/**
	 * Constructs the Instruction Scene with image of
	 *  Sudoku rules and start button.
	 * @return Scene
	 */
	public Scene initGameStartScene(Stage stage) {

		Group view = new Group();

		ImageView gameStartView = new ImageView(startImage);
		gameStartView.setFitHeight(640);
		gameStartView.setFitWidth(810);
		gameStartView.relocate(0, 0);
		Button buttonGameStart = new Button(null, new ImageView(startBImage));
		Button buttonHelp = new Button(null, new ImageView(helpBImage));

		// Instruction Screen
		view.getChildren().add(gameStartView);

		//Start Button
		view.getChildren().add(buttonGameStart);
		buttonGameStart.setStyle("-fx-border-color: transparent;"
				+ "-fx-border-width: 0;"
				+ "-fx-background-radius: 0;"
				+ "-fx-background-color: transparent;"
				+ "-fx-font-family:'Segoe UI', Helvetica, Arial, sans-serif;"
				+ "-fx-font-size: 1em;"
				+ "-fx-text-fill: #828282;");
		buttonGameStart.setTranslateX(150);
		buttonGameStart.setTranslateY(400);

		view.getChildren().add(buttonHelp);
		buttonHelp.setStyle("-fx-border-color: transparent;"
				+ "-fx-border-width: 0;"
				+ "-fx-background-radius: 0;"
				+ "-fx-background-color: transparent;"
				+ "-fx-font-family:'Segoe UI', Helvetica, Arial, sans-serif;"
				+ "-fx-font-size: 1em;"
				+ "-fx-text-fill: #828282;");
		buttonHelp.setTranslateX(450);
		buttonHelp.setTranslateY(400);

		buttonGameStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				stage.setScene(initInstructionScene(stage));
			}
		});

		buttonHelp.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				stage.setScene(initInstructionScene(stage));
			}
		});

		Scene scene = new Scene(view, 810, 640);
		return scene;

	}

	public Scene initInstructionScene(Stage stage) {

		Group view = new Group();

		ImageView gameView = new ImageView(instructionImage);
		Button buttonGameStart = new Button(null, new ImageView(startBImage));
		
		view.getChildren().add(gameView);
		
		view.getChildren().add(buttonGameStart);
		buttonGameStart.setStyle("-fx-border-color: transparent;"
				+ "-fx-border-width: 0;"
				+ "-fx-background-radius: 0;"
				+ "-fx-background-color: transparent;"
				+ "-fx-font-family:'Segoe UI', Helvetica, Arial, sans-serif;"
				+ "-fx-font-size: 1em;"
				+ "-fx-text-fill: #828282;");
		buttonGameStart.setTranslateX(500);
		buttonGameStart.setTranslateY(450);
		
		buttonGameStart.setOnAction(new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e) {
				stage.setScene(initGameScene());
			}
		});

		//Create the scene with the Instruction Components
		Scene scene = new Scene(view, 810, 640);
		return scene;

	}
	
	public Scene initGameScene() {

		Group view = new Group();

		ImageView gameView = new ImageView(boardImage);
		
		view.getChildren().add(gameView);
		
		//Create the scene with the Instruction Components
		Scene scene = new Scene(view, 810, 640);
		return scene;

	}

	void initUI(Stage stage) {

		Scene GameStartScene = initGameStartScene(stage);
		stage.setTitle("Sudoku Game");
		stage.setScene(GameStartScene);
		stage.show();

	}

	AnimationTimer timer = new AnimationTimer() {
		@Override
		public void handle(long now) {
		}
	};

}
