/**
 * The View_Instruction class that displays an Instruction Scene
 * with Sudoku Rules.
 * 
 * @author cassie
 */

package SudokuGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class View_Instruction extends Application{
	
	//Images for Instruction Screen
	Image instructions_image = new Image("/image/instructions.png"),
			start_image = new Image("/image/start.png");
	
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
	public Scene initInstructionScene() {
		
		Group view = new Group();

		// Instruction Screen
		ImageView instruction_view = new ImageView(instructions_image);
		instruction_view.setFitHeight(640);
		instruction_view.setFitWidth(810);
		instruction_view.relocate(0, 0);
		view.getChildren().add(instruction_view);
		
		
		//Start Button
		Button buttonInstructionStart = new Button(null, new ImageView(start_image));
		view.getChildren().add(buttonInstructionStart);
		buttonInstructionStart.setStyle("-fx-border-color: transparent;"
	    + "-fx-border-width: 0;"
	    + "-fx-background-radius: 0;"
	    + "-fx-background-color: transparent;"
	    + "-fx-font-family:'Segoe UI', Helvetica, Arial, sans-serif;"
	    + "-fx-font-size: 1em;" /* 12 */
	    + "-fx-text-fill: #828282;");
		
		
		/*buttonInstructionStart.setStyle("-fx-faint-focus-color: transparent;"
		 
				+ "-fx-focus-color: transparent;"
				+ "-fx-font: 22 arial;"
				+ "-fx-background-insets: -1, 0, 1, 2;");
		*/
		
		//Location of Button
		buttonInstructionStart.setTranslateX(475);
		buttonInstructionStart.setTranslateY(450);
		
		//Create the scene with the Instruction Components
		Scene scene = new Scene(view, 810, 640);
		return scene;
		
	}
	
	// Instruction Screen Appears
	void initUI(Stage stage) {
		Scene InstructionScene = initInstructionScene();

		//Controller controller = new StartController();
		stage.setTitle("Sudoku Rules");
		stage.setScene(InstructionScene);
		stage.show();
	}
	
	AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
        }
    };

}
