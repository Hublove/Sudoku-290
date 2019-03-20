package SudokuGame;

import java.util.ArrayList;

/**
 * The class that will contain information about the whole Sudoku game board
 */
public class Board {
	Block blocks[];

	/**
	 * Initialize Board with 9 empty Block classes.
	 */
	public Board() {
		this.blocks = new Block[9];
		for (int i = 0; i < 9; i++) {
			blocks[i] = new Block();
		}
	}

	/**
	 * Returns the num of the Box at the given xy-coordinate.
	 *
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return the num of the Box
	 */
	public int getNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getNum((x % 3) + (y % 3) * 3);
	}

	/**
	 * Sets the num of the Box at the given xy-coordinate
	 * and removes that num from avalNum at the corresponding
	 * row and column.
	 *
	 * @param x   x-coordinate
	 * @param y   y-coordinate
	 * @param num the new num value of the Box
	 */
	public void setNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setNum((x % 3) + (y % 3) * 3, num);
		for (int i = 0; i < 9; i++) {
			remAvalNum(i, y, num);
			remAvalNum(x, i, num);
		}
	}

	/**
	 * Removes the given num from the Box at the given xy-coordinate. 
	 *
	 * @param x  x-coordinate
	 * @param y  y-coordinate
	 * @param num the removed num value from the Box
	 */
	public void remAvalNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].remAvalNum((x % 3) + (y % 3) * 3, num);
	}

	/**
	 * Returns the avalNum of the Box at given xy-coordinate.
	 *
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getAvalNum((x % 3) + (y % 3) * 3);
	}

	/**
	 * Sets Box's num at the xy-coordinate based on Box's setUserNum description. 
	 *
	 * @param x  x-coordinate
	 * @param y  y-coordinate
	 * @param num the new num value for the Box
	 */
	public void setUserNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setUserNum((x % 3) + (y % 3) * 3, num);
	}

	/**
	 * Returns the userNum of the Box at the given xy-coordinate.
	 * 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getUserNum((x % 3) + (y % 3) * 3);
	}

	/**
	 * Returns the Blocks of the Board.
	 * @return Block[]
	 */
	
	public Block[] getBlocks() {
		return this.blocks;
	}
}
