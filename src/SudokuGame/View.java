package SudokuGame;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

/**
 * view part of the Sudoku game
 */
public class View extends Application{	
	
	static Image boardBackImage = new Image("/image/bordBack.png"),
			numBackImage = new Image("/image/numBack.png"),
			numBackSelImage = new Image("/image/numBackSel.png"),
			gearImage = new Image("/image/gear.png");
	
	ImageView numView[][][][],
	//[x coordinate for box][y coordinate for box][x coordinate for temp num][y coordinate for temp num] 
	//the last two count start at 1. 0 for the big view of that box
		numBackView[][], gearView;
	Group numViewGroup[][];
	Text timeText;
	
	SudokuModel model;
	Controller controller;
	Save save= new Save();
	Load load=new Load();
	long timeCounter;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	
	public Scene initStartScene() {
		Scene scene = new Scene();
		return scene;
	}
	
	public Scene initEndScene() {
		Scene scene = new Scene();
		return scene;
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
		
		//Create a drop down menu for save and load options.
		Menu Options = new Menu("Options");
		MenuItem menuItem1 = new MenuItem("Save");
		MenuItem menuItem2 = new MenuItem("Load");
		Options.getItems().add(menuItem1);
		Options.getItems().add(menuItem2);
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().add(Options);
		view.getChildren().add(menuBar);
		
		model = new SudokuModel();
		System.out.println("Tried: " + model.genNewGame() + " times genNewGame");
		model.diGenGame();
		Scene scene = new Scene(view, 810, 640);
		//imageView of background of number boxes
		numBackView = new ImageView[9][9];
		numView = new ImageView[9][9][4][4];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				numBackView[x][y] = new ImageView(numBackImage);
				numBackView[x][y].relocate(55+x*60, 55+y*60);
				view.getChildren().add(numBackView[x][y]);
				numView[x][y][0][0] = new ImageView();
				if (model.board.getNum(x, y) > 0) {
					numView[x][y][0][0].setImage(Box.cnums[model.board.getNum(x, y)]);
				}
				numView[x][y][0][0].setFitHeight(40);
				numView[x][y][0][0].setFitWidth(32);
				numView[x][y][0][0].relocate(64+x*60, 60+y*60);
				view.getChildren().add(numView[x][y][0][0]);
				for (int sx = 1; sx < 4; sx++) {//add temp views for that box
					for (int sy = 1; sy < 4; sy++) {
						numView[x][y][sx][sy] = new ImageView(Box.nums[(sx) + (3 - sy) * 3]);
						numView[x][y][sx][sy].setFitHeight(13);
						numView[x][y][sx][sy].setFitWidth(10);
						numView[x][y][sx][sy].relocate(64+x*60+(sx-1)*16, 60+y*60+(sy-1)*16);
						numView[x][y][sx][sy].setVisible(false);
						view.getChildren().add(numView[x][y][sx][sy]);
					}
				}
			}
		}
		
		//set up timer related view
		gearView = new ImageView(gearImage);
		gearView.setFitHeight(200);
		gearView.setFitWidth(200);
		gearView.relocate(595, 525);
		view.getChildren().add(gearView);
		timeText = new Text(648, 630, "00:00");
		timeText.setFont(new Font(40));
		view.getChildren().add(timeText);

		//Instructions for when save is selected
		menuItem1.setOnAction(e -> {
		    System.out.println("Save is Selected");
		    save.setBoard(this.model.board);
		    	try {
					//FileOutputStream fileoutput = new FileOutputStream("save.ser");
					int saveStatus=save.saveFile();
				    if (saveStatus==0) {
				    	System.out.println("Save succesfull");
				    }
				    else {
				    	System.out.println("Save unsuccesfull");
				    }
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}    
		});
		
		// Instructions for when load is selected
		menuItem2.setOnAction(e -> {
		    System.out.println("Load is Selected");
					FileInputStream fileinput;
					try {
						fileinput = new FileInputStream("save.ser");
						ObjectInputStream object = new ObjectInputStream(fileinput);
						System.out.println("Deserialising");
						Board boardLoaded=(Board) object.readObject();
						object.close();
						System.out.println("Setting board");
						model.setBoard(boardLoaded);
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		});
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
