package SudokuGame;

import java.util.ArrayList;
/**
 *The Block class will contain information about a single block from the board.
 */
public class Block {

	Box boxs[];
	
	/**
	 *Initializes Block with 9 empty Box classes.
	 */
	
	public Block() {
		this.boxs = new Box[9];
		for (int i = 0; i < 9; i++) {
			boxs[i] = new Box();
		}
	}
	
	/**
	 * Retrieves the number of the Box at the given index. 
	 * Box index starts from left moving to right.
	 * @param index index of the box.
	 * @return the value the box holds.
	 */
	public int getNum(int index) {
		return this.boxs[index].getNum();
	}
	
	/**
	 * Retrieves the value of the Box at the given xy-coordinate.
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @return the integer value of the Box.
	 */
	
	public int getNum(int x, int y) {
		return getNum(x + y * 3);
	}
	
	/**
	 * Allocates a number value to the Box at the given index.  
	 * Removes number from avalNum from all Boxes on this Block.
	 * @param index index of the box.
	 * @param num the new number of the box.
	 */
	
	public void setNum(int index, int num) {
		this.boxs[index].setNum(num);
		for (int i = 0; i < 9; i ++) {
			remAvalNum(i,num);
		}
	}
	
	/**
	 * Sets number of the Box at the given xy-coordinate. 
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @param num the new number value of the Box.
	 */
	public void setNum(int x, int y, int num) {
		setNum(x + y * 3, num);
	}
	
	/**
	 * Removes the number from avalNum at the Box with the given index.
	 * @param index index of the box.
	 * @param num the number value to be removed.
	 */
	public void remAvalNum(int index, int num) {
		this.boxs[index].remAvalNum(num);
	}
	
	/**
	 * Removes the number from avalNum from the Box at the given xy-coordinate.
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @param num the number value to be removed.
	 */
	
	public void remAvalNum(int x, int y, int num) {
		remAvalNum(x + y * 3, num);
	}
	
	/**
	 * Returns the avalNum from the Box at the given index.
	 * @param index index of the box.
	 * @return an array list of available numbers.
	 */
	public ArrayList<Integer> getAvalNum(int index) {
		return this.boxs[index].getAvalNum();
	}
	
	/**
	 * Returns the avalNum from the Box at the given xy-coordinate. 
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @return an array list of available numbers.
	 */
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return getAvalNum(x + y * 3);
	}
	
	/**
	 * Sets userNum with a number for a Box at the given index. 
	 * @param index index of the box.
	 * @param num the new num value for Box.
	 */
	
	public void setUserNum(int index, int num) {
		this.boxs[index].setUserNum(num);
	}
	
	/**
	 * Sets the userNum with a number for the Box at the given index.  
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @param num the new num value for Box.
	 */
	
	public void setUserNum(int x, int y, int num) {
		setUserNum(x + y * 3, num);
	}
	
	/**
	 * Retrieves the userNum from the Box at the given index. 
	 * @param index index of the Box.
	 * @return array list of numbers from inputed by the user.
	 */
	
	public ArrayList<Integer> getUserNum(int index){
		return this.boxs[index].getUserNum();
	}
	
	/**
	 * Returns the userNum from the Box at the given xy-coordinate.
	 * @param x x-coordinate.
	 * @param y y-coordinate.
	 * @return array list of numbers from inputed by the user.
	 */
	
	public ArrayList<Integer> getUserNum(int x, int y){
		return getUserNum(x + y * 3);
	}
}
