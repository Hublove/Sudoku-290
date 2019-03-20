package SudokuGame;

import java.io.*;
/**
 * The Save class is responsible for serilialsing and saving a board object to a ser file so the player can load previous game states. 
 * The class is used in view when a user selects the save option.
 */

public class Save {
private Board board;
/**
 * This function sets the current Save objects board.
 * The most recent board set will be saved to a ser file and can be loaded again by a user.
 * @param board a board object to be written and stored to a file.
 */
public void setBoard(Board board) {
	this.board=board;
	System.out.println("Board set");
}
/**
 * Retrieves the board set for the current Save object.
 * @return a board object.
 */
public Board getBoard() {
	return this.board;
}
/**
 * This function is responsible for saving board to a file. 
 * The function creates a ser file, serializes it and writes a board object to the file using an ObjectOutputStream.
 * @return is 0 if the operation was successful or 1 if an error occurred.
 */
public int saveFile(){
	try {
		FileOutputStream file = new FileOutputStream("save.ser");
        ObjectOutputStream out = new ObjectOutputStream(file);
        Board board=getBoard();
        out.writeObject(board);
        out.close();
        file.close();
        System.out.printf("Data Saved");
        return 0;
	}
	catch (IOException i) {
        i.printStackTrace();
        return 1;
     }
}
}
