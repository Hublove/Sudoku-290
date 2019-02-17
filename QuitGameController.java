package SudokuGame;

import java.awt.event.ActionEvent;

public class QuitGameController extends Controller{
private Board game;
}
public QuitGameController(Board game) {
	setGame(game);
}
public Board getGame() {
	return game;
}
public void setGame(Board game) {
	this.game=game;
}
public void eventaction(ActionEvent e) {
	System.exit(-1);
}
}

