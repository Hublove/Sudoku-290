package SudokuGame;
/**
 * A child class of the Controller class.
 * Sets the current view of the Controller class to a view seen by the user.
 */
public class StartController extends Controller{
/**
 * Calls Controllers builder function to set the new view obtained by the class.
 * @param view a view object that the user sees and should have control over.
 */
	StartController(View view) {
		super(view);
	}

}
