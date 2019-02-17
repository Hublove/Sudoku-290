package SudokuGame;

public class CheckGameSolutionController extends Controller{
	private Board game;


public CheckGameSolutionController(Board game) {
	setGame(game);
	//game.checkSolution();
}
public void actionevent(ActionEvent e) {
	getGame().checkGame();
}
}


