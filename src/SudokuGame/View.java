package SudokuGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class View extends Application{	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	
	public Scene initStartScene() {
		Scene scene = new Scene();
	}
	
	public Scene initEndScene() {
		Scene scene = new Scene();
	}
	
	public Scene initGameScene() {
		Scene scene = new Scene();
	}
	
	void initUI(Stage stage) {
		Scene scene = initStartScene();
		Controller controller = new StartController();
		
		stage.setTitle("Sudoku game");
		stage.setScene(scene);
		stage.show();
	}
	
	AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
        	control.updateTimer();
        }
    };
    timer.start();

}
