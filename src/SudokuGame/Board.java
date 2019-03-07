package SudokuGame;

import java.util.ArrayList;


/**
 *The class that will contain information about the
 *whole Sudoku game board
 */
public class Board {
	Block blocks[];

	/**
	 * initialize Board with 9 empty block
	 */
	public Board() {
		this.blocks = new Block[9];
		for (int i = 0; i < 9; i++) {
			blocks[i] = new Block();
		}
	}

	/**
	 * get the num of the Box at given coordinate
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return the num at that Box
	 */
	public int getNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getNum((x % 3) + (y % 3) * 3);
	}

	/**
	 * set the num of the Box at given coordinate
	 * and remove that num from avalNum at the corresponding
	 * row and column
	 *
	 * @param x   x coordinate
	 * @param y   y coordinate
	 * @param num new num of that Box
	 */
	public void setNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setNum((x % 3) + (y % 3) * 3, num);
		for (int i = 0; i < 9; i++) {
			remAvalNum(i, y, num);
			remAvalNum(x, i, num);
		}
	}

	/**
	 * remove the given num at the box at given coordinate
	 *
	 * @param x   x coordinate
	 * @param y   y coordinate
	 * @param num num want to remove
	 */
	public void remAvalNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].remAvalNum((x % 3) + (y % 3) * 3, num);
	}

	/**
	 * return the avalNum at the box at given coordinate
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getAvalNum((x % 3) + (y % 3) * 3);
	}

	/**
	 * set userNum with the given num at the box at given coordinate
	 *
	 * @param x   x coordinate
	 * @param y   y coordinate
	 * @param num the num want to change
	 */
	public void setUserNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setUserNum((x % 3) + (y % 3) * 3, num);
	}

	/**
	 * return userNum at the box at given coordinate
	 *
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getUserNum((x % 3) + (y % 3) * 3);
	}

	public Block[] getBlocks() {
		return this.blocks;
	}
}
