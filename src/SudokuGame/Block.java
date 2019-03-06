package SudokuGame;

import java.util.ArrayList;
/**
 *The class that will contain information about a single block
 */
public class Block {

	Box boxs[];
	
	/**
	 *create a block that have 9 empty box
	 */
	public Block() {
		this.boxs = new Box[9];
		for (int i = 0; i < 9; i++) {
			boxs[i] = new Box();
		}
	}
	
	/**
	 * return num of the Box at the given index count from left to right
	 * up to down
	 * @param index index of the box
	 * @return int num of that box
	 */
	public int getNum(int index) {
		return this.boxs[index].getNum();
	}
	
	/**
	 * return num of the Box at the given coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return int num of that box
	 */
	public int getNum(int x, int y) {
		return getNum(x + y * 3);
	}
	
	/**
	 * set num of the Box at the given index count from left to right
	 * up to down and remove num from avalNum from all box at this block
	 * @param index index of the box
	 * @param num the new num of that box
	 */
	public void setNum(int index, int num) {
		this.boxs[index].setNum(num);
		for (int i = 0; i < 9; i ++) {
			remAvalNum(i,num);
		}
	}
	
	/**
	 * set num of the Box at the given coordinate
	 * and remove num from avalNum from all box at this block
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param num the new num of that box
	 */
	public void setNum(int x, int y, int num) {
		setNum(x + y * 3, num);
	}
	
	/**
	 * remove the num from avalNum from the Box at
	 * given index count from left to right
	 * up to down
	 * @param index index of the box
	 * @param num number want to remove
	 */
	public void remAvalNum(int index, int num) {
		this.boxs[index].remAvalNum(num);
	}
	
	/**
	 * remove the num from avalNum from the Box at
	 * given coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param num number want to remove
	 */
	public void remAvalNum(int x, int y, int num) {
		remAvalNum(x + y * 3, num);
	}
	
	/**
	 * return the avalNum from the Box at
	 * given index count from left to right
	 * up to down
	 * @param index index of the box
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int index) {
		return this.boxs[index].getAvalNum();
	}
	
	/**
	 * return the avalNum from the Box at
	 * given coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return getAvalNum(x + y * 3);
	}
	
	/**
	 * set userNum with the given num at the Box at given
	 * index count from left to right
	 * up to down
	 * @param index index of the box
	 * @param num num want to change
	 */
	public void setUserNum(int index, int num) {
		this.boxs[index].setUserNum(num);
	}
	
	/**
	 * set userNum with the given num at the Box at given
	 * index coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param num num want to change
	 */
	public void setUserNum(int x, int y, int num) {
		setUserNum(x + y * 3, num);
	}
	
	/**
	 * return the userNum from the Box at
	 * given index count from left to right
	 * up to down
	 * @param index index of the box
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int index){
		return this.boxs[index].getUserNum();
	}
	
	/**
	 * return the userNum from the Box at
	 * given coordinate
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int x, int y){
		return getUserNum(x + y * 3);
	}
}
