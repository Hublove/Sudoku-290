/**
 * The View_Instruction class that displays an Instruction Scene
 * with Sudoku Rules.
 * 
 * @author cassie
 */

package SudokuGame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.animation.AnimationTimer;

public class View_ColorPalette extends Application{
	
	//Images for Instruction Screen
	Image colorBackgroundImg = new Image("/image/bordBack.png");
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		initUI(primaryStage);
	}
	
	/**
	 * Constructs the Color Palette Scene in order to choose
	 * font and background color of game board.
	 * @return Scene
	 */
	public Scene initColorPaletteScene() {
		
		Group groupColor = new Group();

		//Color Settings Screen
		ImageView colorView = new ImageView(colorBackgroundImg);
		colorView.setFitWidth(600);
		colorView.setFitHeight(450);
		colorView.relocate(0, 0);
		groupColor.getChildren().add(colorView);
		
		
		//Label of Color Settings Title
		Label colorTitle = new Label("SudoQ Color Palette");
		colorTitle.setFont(new Font("Arial",40));
		colorTitle.setTextFill(Color.web("#ffffff"));
		colorTitle.setLayoutX(120);
		colorTitle.setLayoutY(50);
		groupColor.getChildren().add(colorTitle);
		
		
		
		//Background ColorPicker
		final ColorPicker pickBackgroundColor = new ColorPicker();
		pickBackgroundColor.setValue(Color.WHITE);

		//Background Circle
		final Circle backgroundCircle = new Circle(20);
		backgroundCircle.setFill(pickBackgroundColor.getValue());
		
		//Background ColorPicker ActionEvent
		pickBackgroundColor.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				backgroundCircle.setFill(pickBackgroundColor.getValue());
				
			}
			
		});
		
		//Background Label FlowPane
		Label backgroundLabel = new Label("Set Background Color");
		backgroundLabel.setFont(new Font("Arial",20));
		backgroundLabel.setTextFill(Color.web("#ffffff"));
		
		//Background FlowPane
		FlowPane backgroundPane = new FlowPane();
		backgroundPane.setPadding(new Insets(10));
		backgroundPane.setHgap(10);
		backgroundPane.getChildren().addAll(backgroundLabel, pickBackgroundColor, backgroundCircle);
		backgroundPane.setLayoutY(100);
		backgroundPane.setLayoutX(100);
		groupColor.getChildren().add(backgroundPane);
		
		
	
		//Font ColorPicker
		final ColorPicker pickFontColor = new ColorPicker();
		pickFontColor.setValue(Color.WHITE);
		
		//Font Circle
		final Circle fontCircle = new Circle(20);
		fontCircle.setFill(pickFontColor.getValue());
		
		
		//Font ColorPicker ActionEvent
		pickFontColor.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				fontCircle.setFill(pickFontColor.getValue());
			}
		});
		
		//Font Label FlowPane 
		Label fontLabel = new Label("Set Font Color");
		fontLabel.setFont(new Font("Arial",20));
		fontLabel.setTextFill(Color.web("#ffffff"));
		
		
		//Font FlowPane
		FlowPane fontPane = new FlowPane();
		fontPane.setPadding(new Insets(10));
		fontPane.setHgap(10);
		fontPane.getChildren().addAll(fontLabel, pickFontColor, fontCircle);
		fontPane.setLayoutY(150);
		fontPane.setLayoutX(100);
		groupColor.getChildren().add(fontPane);
		
		
		
		
		//Border ColorPicker
		final ColorPicker pickBorderColor = new ColorPicker();
		pickBorderColor.setValue(Color.WHITE);
		
		//Border Circle
		final Circle borderCircle = new Circle(20);
		borderCircle.setFill(pickBorderColor.getValue());
		
		//Border ColorPicker ActionEvent
		pickBorderColor.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				borderCircle.setFill(pickBorderColor.getValue());
			}
		});
		
		//Border Label FlowPane 
		Label borderLabel = new Label("Set Border Color");
		borderLabel.setFont(new Font("Arial",20));
		borderLabel.setTextFill(Color.web("#ffffff"));

		//Border FlowPane
		FlowPane borderPane = new FlowPane();
		borderPane.setPadding(new Insets(10));
		borderPane.setHgap(10);
		borderPane.getChildren().addAll(borderLabel, pickBorderColor, borderCircle);
		borderPane.setLayoutY(200);
		borderPane.setLayoutX(100);
		groupColor.getChildren().add(borderPane);
		
		
	
		//Apply Changes Button
		Button buttonColorApply = new Button("Apply Changes");
		groupColor.getChildren().add(buttonColorApply);
		buttonColorApply.setStyle("-fx-faint-focus-color: transparent;"
				+ "-fx-focus-color: transparent;"
				+ "-fx-font: 22 arial;"
				+ "-fx-base: #ffffff;"
				+ "-fx-background-insets: -1.4, 0, 1, 2;");
		
		//Location of Apply Changes Button
		buttonColorApply.setTranslateX(100);
		buttonColorApply.setTranslateY(300);
		
		
		//Default Board Button
		Button buttonColorDefault = new Button("Default Settings");
		groupColor.getChildren().add(buttonColorDefault);
		buttonColorDefault.setStyle("-fx-faint-focus-color: transparent;"
				+ "-fx-focus-color: transparent;"
				+ "-fx-font: 22 arial;"
				+ "-fx-base: #ffffff;"
				+ "-fx-background-insets: -1.4, 0, 1, 2;");
		
		//Location of Default Board Button
		buttonColorDefault.setTranslateX(300);
		buttonColorDefault.setTranslateY(300);
		
		//Create the Scene with the Color Settings
		Scene sceneColor = new Scene(groupColor, 810, 640);
		return sceneColor;
		
	}
	
	// Color Settings Screen Appears
	void initUI(Stage stage) {
		Scene colorPaletteScene = initColorPaletteScene();

		//Controller controller = new StartController();
		stage.setTitle("Color Palette");
		stage.setScene(colorPaletteScene);
		stage.setWidth(600);
		stage.setHeight(450);
		stage.show();
	}
	
	AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
        }
    };

}
