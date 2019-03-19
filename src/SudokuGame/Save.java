package SudokuGame;

import java.io.*;

import javax.swing.JFileChooser;
public class Save {
private Board board;
public void setBoard(Board board) {
	this.board=board;
	System.out.println("Board set");

}
public Board getBoard() {
	return this.board;
}

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
