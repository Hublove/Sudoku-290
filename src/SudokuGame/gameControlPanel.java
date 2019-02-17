package SudokuGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class gameControlPanel extends GridPane implements EventHandler<ActionEvent> {

	private View view; // So we can talk to our parent or other components of the view
	private instructionButtonHandler instructionHandler;
	private restartButtonHandler restartHandler;

	public gameControlPanel(View view) {

		this.view = view;
		
		Button submitButton = new Button("Submit");
		submitButton.setMinWidth(100);
		this.add(submitButton, 0, 0);
		submitButton.setOnAction(this);
		
		Button instructionButton = new Button("Instruction");
		instructionButton.setMinWidth(100);
		this.add(instructionButton, 0, 1);
		instructionButton.setOnAction(instructionHandler);

		
		Button restartButton = new Button("Restart");
		restartButton.setMinWidth(100);
		this.add(restartButton, 0, 2);
		restartButton.setOnAction(restartHandler);
	}
	@Override
	//handle after submit button is being pressed
	public void handle(ActionEvent event) {
		//show the message if the player win the game 
		Alert information = new Alert(Alert.AlertType.INFORMATION,"You Win!!!!");
		information.setTitle("You Win!!"); 
		information.setHeaderText("You Win!!"); 
		information.showAndWait();
	}
}
