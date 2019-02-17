package SudokuGame;

public class ButtonController {
private Panel panel;//to be implemented
private Board game;
}
public void assignButtons() {
	panel.newButton.addActionListener(new NewGameController(game));
	   panel.quitButton.addActionListener(new QuitGameController(game));
	   panel.checkButton.addActionListener(new CheckGameController(game));
	  
}
}
