package SudokuGame;

import java.awt.event.ActionEvent;

public class SelectBoxController extends Controller {
private Game game;
public SelectBoxController(Board game) {
	setGame(game);
}
public Board getGame() {
	return game;
}
public void setGame(Board game) {
	this.game=game;
}
public void actionevent(ActionEvent e) {
	getGame().setBox(e.getActionCommand()); //To be implemented
}

}
