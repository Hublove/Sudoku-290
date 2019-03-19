package SudokuGame;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * The Load class deserializes and loads saved game data from a file. 
 * @param board the board to update the model with
 */
public class Load {
	private Board board;
	/**
	 * This function sets the new board extracted from the file
	 * @param board the board obtained from deserialzing the file
	 */
	public void setBoard(Board board) {
	this.board=board;
	}
	/**
	 * This function returns the board currently set for the class.
	 * @param board the board obtained from deserialzing the file
	 */
	public Board getBoard() {
		return this.board;
	}
	/**
	 * This function deserializes a file selected by the user.
	 * The function converts the file to an ObjectOutputStream that deserializes objects previously written to a file.
	 * The remainder of the function reads in the new board from the file, sets it to the classes board, closes all files and handles exceptions. 
	 * @param file file selected by user to load previous game data.
	 * @return the new board object deserialized from the file
	 */
	public Board loadFile(FileInputStream file){
        try {
		ObjectInputStream in = new ObjectInputStream(file);
		System.out.println("Loading Board");
        Board board = (Board) in.readObject();
        setBoard(board);
        in.close();
        file.close();
     
     } catch (IOException i) {
        i.printStackTrace();
     } catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
		return getBoard(); 
  

	}
	}
