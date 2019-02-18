package SudokuGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class View_temp extends Application{	
	
	Image boardBackImage = new Image("/image/bordBack.png"),
			numBackImage = new Image("/image/numBack.png"),
			num1Image = new Image("/image/num/1d.png"),
			num2cImage = new Image("/image/num/2c.png"),
			startscreenImage = new Image("/image/startscreen.png");
	
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
	
	/**
	 * the constructor of the game scene
	 * (include show some numbers as sample for now)
	 * @return Scene
	 * 		the scene that show to player when in
	 * 		sudoku game
	 */
	public Scene initGameScene() {
		Group view = new Group();
		//back ground imageView
		ImageView boardBackView = new ImageView(boardBackImage);
		boardBackView.setFitHeight(640);
		boardBackView.setFitWidth(810);
		boardBackView.relocate(0, 0);
		view.getChildren().add(boardBackView);
		
		
		ImageView startscreenView = new ImageView(startscreenImage);
		startscreenView.setFitHeight(640);
		startscreenView.setFitWidth(810);
		startscreenView.relocate(0, 0);
		view.getChildren().add(startscreenView);
		
		
		/*
		//image of the black lines to show the sudoku board
		Rectangle boardUp = new Rectangle(540, 2);
		boardUp.relocate(50, 50);
		view.getChildren().add(boardUp);
		
		Rectangle boardDown = new Rectangle(540, 2);
		boardDown.relocate(50, 588);
		view.getChildren().add(boardDown);
		
		Rectangle boardLeft = new Rectangle(2, 540);
		boardLeft.relocate(50, 50);
		view.getChildren().add(boardLeft);
		
		Rectangle boardRight = new Rectangle(2, 540);
		boardRight.relocate(588, 50);
		view.getChildren().add(boardRight);
		
		Rectangle inBoardH1 = new Rectangle(540, 2);
		inBoardH1.relocate(50, 229);
		view.getChildren().add(inBoardH1);
		
		Rectangle inBoardH2 = new Rectangle(540, 2);
		inBoardH2.relocate(50, 409);
		view.getChildren().add(inBoardH2);
		
		Rectangle inBoardV1 = new Rectangle(2, 540);
		inBoardV1.relocate(229, 50);
		view.getChildren().add(inBoardV1);
		
		Rectangle inBoardV2 = new Rectangle(2, 540);
		inBoardV2.relocate(409, 50);
		view.getChildren().add(inBoardV2);
		
		//imageView of background of number boxes
		ImageView numBackViews[][] = new ImageView[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				numBackViews[x][y] = new ImageView(numBackImage);
				numBackViews[x][y].relocate(55+x*60, 55+y*60);
				view.getChildren().add(numBackViews[x][y]);
			}
		}
		

		//sample of number 1 and 2 in box
		ImageView num1View = new ImageView(num1Image);
		num1View.setFitHeight(40);
		num1View.setFitWidth(32);
		num1View.relocate(64+0*60, 60+0*60);
		view.getChildren().add(num1View);
		
		ImageView num2cView = new ImageView(num2cImage);
		num2cView.setFitHeight(40);
		num2cView.setFitWidth(32);
		num2cView.relocate(64+1*60, 60+1*60);
		view.getChildren().add(num2cView);
		*/
		
		Scene scene = new Scene(view, 810, 640);
		return scene;
	}
	
	public Scene initInstructionScene() {
		Scene scene = new Scene();
	}
	
	void initUI(Stage stage) {
		Scene scene = initGameScene();//changed for test
		Controller controller = new StartController();
		
		stage.setTitle("Sudoku game");
		stage.setScene(scene);
		stage.show();
	}
	
	AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
        }
    };

}
