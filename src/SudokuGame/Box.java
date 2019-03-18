package SudokuGame;

import java.util.ArrayList;

import javafx.scene.image.Image;


/**
 *The class that will contain information about a single Box.
 */
public class Box {
	//Blue number images
	static Image nums[] = {new Image("/image/num/0d.png"), new Image("/image/num/1d.png"),
			new Image("/image/num/2d.png"), new Image("/image/num/3d.png"),
			new Image("/image/num/4d.png"), new Image("/image/num/5d.png"),
			new Image("/image/num/6d.png"), new Image("/image/num/7d.png"),
			new Image("/image/num/8d.png"), new Image("/image/num/9d.png"),};//for user input number
	
	//Yellow number images
	static Image cnums[] = {new Image("/image/num/0c.png"), new Image("/image/num/1c.png"),
			new Image("/image/num/2c.png"), new Image("/image/num/3c.png"),
			new Image("/image/num/4c.png"), new Image("/image/num/5c.png"),
			new Image("/image/num/6c.png"), new Image("/image/num/7c.png"),
			new Image("/image/num/8c.png"), new Image("/image/num/9c.png"),};//for system set number
	
	int num;
	ArrayList<Integer> userNum, //for user input
		avalNum;//to generate new game
	
	/**
	 * Initializes Box with the given num.
	 * @param num number set by generator
	 */
	public Box(int num) {
		this.num = num;
		userNum = new ArrayList<>();
		avalNum = new ArrayList<>();
	}
	
	/**
	 * Initializes Box. 
	 */
	public Box() {
		this.num = -1;
		userNum = new ArrayList<>();
		avalNum = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			avalNum.add(i);
		}
	}
	
	/**
	 * Removes the given num from avalNum. 
	 * @param num that want to remove
	 */
	public void remAvalNum(int num) {
		avalNum.remove((Integer)num);
	}
	
	/**
	 * Returns avalNum. 
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum() {
		return avalNum;
	}
	
	/**
	 * Returns Box's num.
	 * @return int
	 */
	public int getNum() {
		return this.num;
	}
	
	/**
	 * Sets num to the given num.
	 * @param num the new value of num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * Adds the num to userNum if num is not in userNum
	 * and removes num from userNum if num is in userNum.
	 * @param num want to change
	 */
	public void setUserNum(int num) {
		if (userNum.indexOf(num) < 0) {//not in userNum
			userNum.add(num);
			return;
		}
		userNum.remove((Integer)num);
	}
	
	/**
	 * Returns userNum. 
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(){
		return userNum;
	}
}
