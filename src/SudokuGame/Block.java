package SudokuGame;

import java.util.ArrayList;
/**
 *The class that will contain information about a single Block.
 */
public class Block {

	Box boxs[];
	
	/**
	 *Initializes Block with have 9 empty Box classes.
	 */
	public Block() {
		this.boxs = new Box[9];
		for (int i = 0; i < 9; i++) {
			boxs[i] = new Box();
		}
	}
	
	/**
	 * Returns the num of the Box at the given index. 
	 * (count from left to right)
	 * up to down
	 * @param index index of the box
	 * @return int the num value of the Box
	 */
	public int getNum(int index) {
		return this.boxs[index].getNum();
	}
	
	/**
	 * Returns the num of the Box at the given xy-coordinate.
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return int the num value of the Box
	 */
	public int getNum(int x, int y) {
		return getNum(x + y * 3);
	}
	
	/**
	 * Sets the num of the Box at the given index 
	 * (count from left to right and up to down) 
	 * and removes num from avalNum from all Boxes at this Block.
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
	 * Sets num of the Box at the given xy-coordinate. 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param num the new num value of the Box
	 */
	public void setNum(int x, int y, int num) {
		setNum(x + y * 3, num);
	}
	
	/**
	 * Removes the num from avalNum from the Box at
	 * the given index.
	 * (count from left to right and up to down)
	 * @param index index of the box
	 * @param num the num value to be removed
	 */
	public void remAvalNum(int index, int num) {
		this.boxs[index].remAvalNum(num);
	}
	
	/**
	 * Removes the num from avalNum from the Box at
	 * the given xy-coordinate.
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param num the num value to be removed
	 */
	public void remAvalNum(int x, int y, int num) {
		remAvalNum(x + y * 3, num);
	}
	
	/**
	 * Returns the avalNum from the Box at
	 * the given index.
	 * (count from left to right and up to down)
	 * @param index index of the box
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int index) {
		return this.boxs[index].getAvalNum();
	}
	
	/**
	 * Returns the avalNum from the Box at
	 * the given xy-coordinate. 
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return getAvalNum(x + y * 3);
	}
	
	/**
	 * Sets userNum with the given num for the Box 
	 * at the given index. 
	 * (count from left to right up to down)
	 * @param index index of the box
	 * @param num the new num value for Box
	 */
	public void setUserNum(int index, int num) {
		this.boxs[index].setUserNum(num);
	}
	
	/**
	 * Sets the userNum with the given num for the Box
	 * at the given index.  
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @param num the new num value for Box
	 */
	public void setUserNum(int x, int y, int num) {
		setUserNum(x + y * 3, num);
	}
	
	/**
	 * Returns the userNum from the Box at
	 * the given index 
	 * (count from left to right and up to down)
	 * @param index index of the Box
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int index){
		return this.boxs[index].getUserNum();
	}
	
	/**
	 * Returns the userNum from the Box at
	 * the given xy-coordinate.
	 * @param x x-coordinate
	 * @param y y-coordinate
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(int x, int y){
		return getUserNum(x + y * 3);
	}
}
