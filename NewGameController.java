package SudokuGame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import model.getGame; //To be implemented

public class NewGameController extends Controller {
private Board game;
public NewGameController(Board game) {
	game.generateboard();//To be implemented
	setModel(game);
	
}
public Board getGame() {
	return game;
}
public void setGame(Board game) {
	this.game=game;
}
public void actionevent(ActionEvent e) {
	getGame.newGame;//To be implemented
}
}
