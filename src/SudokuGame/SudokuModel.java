package SudokuGame;

import javax.swing.text.BadLocationException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * The SudokuModel class represents the data in the game. 
 * @author  Sebastian Stanik
 * @version March 17, 2019
 */
public class SudokuModel {

    public Board board;
    boolean isEditing;
    int editIndex[];

    
    
    /**
     * Initializes a new SudokuModel class.  
     *
     * @param diff The game's level of difficulty (easy, medium, or hard). 
     */
    public SudokuModel() {
        board = new Board();
		isEditing = false;
		editIndex = new int[2];
    }

    /**
     * Determines the difficulty of the game by the given diff. 
     *
     * @param diff The game's level of difficulty (easy, medium, or hard). 
     */
    public void diGenGame(String diff) {
        Random rand = new Random();
        int toRemove = 0;
        int counter = 0;
        int x = 0, y = 0;

        if (diff == "easy") {
            toRemove = 20;
        } else if (diff == "medium") {
            toRemove = 40;
        } else if (diff == "hard") {
            toRemove = 60;
        }

        while (counter < toRemove) {
            x = rand.nextInt(9);
            y = rand.nextInt(9);

            if (board.getNum(x, y) != -1) {
                board.setNum(x, y, -1);
                counter++;
            }

        }

    }

    /**
     * Returns true if the given number is in the given row. 
     *
     * @param row The row that is being checked
     * @param num The number that is being checked
     * @return  If the number is in the row
     */
    public boolean isInRow(int[] row, int num) {
        for (int i = 0; i < 9; i++) {
            if (row[i] == num)
                return true;
        }
        return false;
    }


    /**
     * Generates a new Sudoku board. 
     */
    public void genNewGame() {
        Random rand = new Random();
        int num = 0;

        int[] row = new int[9];

        for (int i = 0; i < 9; i++) {
            while (isInRow(row, num)) {
                num = rand.nextInt(9) + 1;
            }
            row[i] = num;
        }

        setRow(board, row, 0);
        shiftRow(row, 3);
        setRow(board, row, 1);
        shiftRow(row, 3);
        setRow(board, row, 2);

        shiftRow(row, 1);
        setRow(board, row, 3);
        shiftRow(row, 3);
        setRow(board, row, 4);
        shiftRow(row, 3);
        setRow(board, row, 5);

        shiftRow(row, 1);
        setRow(board, row, 6);
        shiftRow(row, 3);
        setRow(board, row, 7);
        shiftRow(row, 3);
        setRow(board, row, 8);

    }


    /**
     * Copies the given row at the given rowNum to the board. 
     *
     * @param board The Board
     * @param row   The number of the row 
     * @param rowNum The index of the row
     */
    public void setRow(Board board, int[] row, int rowNum) {
        for (int i = 0; i < 9; i++) {
            board.setNum(i, rowNum, row[i]);
        }
    }

    /**
     * Shifts the given row by a given amount. 
     *
     * @param row     The number of the row 
     * @param amount  The number of shifts
     */
    public void shiftRow(int[] row, int amount) {

        if (amount == 3) {
            int[] tempRow = new int[3];

            for (int j = 0; j < 3; j++) {
                tempRow[j] = row[j];
            }

            for (int i = 0; i < 6; i++) {
                row[i] = row[i + 3];
            }

            for (int x = 0; x < 3; x++) {
                row[x + 6] = tempRow[x];
            }
        } else if (amount == 1) {
            int temp = row[0];
            for (int i = 0; i < 8; i++) {
                row[i] = row[i + 1];
            }
            row[8] = temp;
        }

    }

    /**
     * Returns true if the game is solved based on Sudoku's rules.
     *
     * @return  true if the game is solved
     */
    public boolean isGameSolved() {
        Block[] blocks = board.getBlocks();

        for (Block block: blocks) {
            if (!isBlockSolved(block))
                return false;
        }

        for (int r = 0; r < 9; r++) {
            if (!isRowSolved(this.board, r)) {
                return false;
            }
        }

        for (int c = 0; c < 9; c++) {
            if (!isColumnSolved(this.board, c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns true if the given block is solved based on the Sudoku rules.
     *
     * @param   block  current Block
     * @return  true if the block is solved
     */
    public boolean isBlockSolved(Block block) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
    		if(block.getUserNum(i).size() != 1 && block.getNum(i) < 0) {
    			return false;
    		}
    		if (block.getNum(i) < 0) {
	    		if (numbers.indexOf(block.getUserNum(i).get(0)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove(block.getUserNum(i).get(0));
	    		}
    		}else {
    			if (numbers.indexOf(block.getNum(i)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove((Integer)block.getNum(i));
	    		}
    		}
        }

        if (!numbers.isEmpty()) {
            return false;
        }

        return true;
    }

    /**
     * Returns true if the given row on the given board is solved 
     * based on Sudoku rules. 
     *
     * @param board    current Board
     * @param rowNum   row number
     * @return  true if the row is solved
     */
    public boolean isRowSolved(Board board, int rowNum) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
    		if(board.getUserNum(i, rowNum).size() != 1 && board.getNum(i, rowNum) < 0) {
    			return false;
    		}
    		if (board.getNum(i, rowNum) < 0) {
	    		if (numbers.indexOf(board.getUserNum(i, rowNum).get(0)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove(board.getUserNum(i, rowNum).get(0));
	    		}
    		}else {
    			if (numbers.indexOf(board.getNum(i, rowNum)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove((Integer)board.getNum(i, rowNum));
	    		}
    		}
        }

        if (!numbers.isEmpty()) {
            return false;
        }
        return true;
    }

    /**
     * Returns true if the given column on the given board is solved 
     * based on Sudoku rules.
     *
     * @param board    current Board
     * @param colNum   column number
     * @return  If the column is solved
     */
    public boolean isColumnSolved(Board board, int colNum) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
    		if(board.getUserNum(colNum, i).size() != 1 && board.getNum(colNum, i) < 0) {
    			return false;
    		}
    		if (board.getNum(colNum, i) < 0) {
	    		if (numbers.indexOf(board.getUserNum(colNum, i).get(0)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove(board.getUserNum(colNum, i).get(0));
	    		}
    		}else {
    			if (numbers.indexOf(board.getNum(colNum, i)) < 0) {
	    			return false;
	    		}else {
	    			numbers.remove((Integer)board.getNum(colNum, i));
	    		}
    		}
        }

        if (!numbers.isEmpty()) {
            return false;
        }
        return true;
    }

	public void setBoard(Board boardLoaded) {
		this.board=boardLoaded;		
	}

}
