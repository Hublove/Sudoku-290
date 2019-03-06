package SudokuGame;

import java.util.ArrayList;

import javafx.scene.image.Image;


/**
 *The class that will contain information about a single box
 */
public class Box {
	static Image nums[] = {new Image("/image/num/0d.png"), new Image("/image/num/1d.png"),
			new Image("/image/num/2d.png"), new Image("/image/num/3d.png"),
			new Image("/image/num/4d.png"), new Image("/image/num/5d.png"),
			new Image("/image/num/6d.png"), new Image("/image/num/7d.png"),
			new Image("/image/num/8d.png"), new Image("/image/num/9d.png"),};
	
	static Image cnums[] = {new Image("/image/num/0c.png"), new Image("/image/num/1c.png"),
			new Image("/image/num/2c.png"), new Image("/image/num/3c.png"),
			new Image("/image/num/4c.png"), new Image("/image/num/5c.png"),
			new Image("/image/num/6c.png"), new Image("/image/num/7c.png"),
			new Image("/image/num/8c.png"), new Image("/image/num/9c.png"),};
	
	int num;
	ArrayList<Integer> userNum, avalNum;
	
	/**
	 * Initialize Box that have the given number
	 * @param num should be system set number
	 */
	public Box(int num) {
		this.num = num;
		userNum = new ArrayList<>();
		avalNum = new ArrayList<>();
	}
	
	/**
	 * Initialize Box that does not have a 
	 * system set number
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
	 * remove the given num from avalNum
	 * @param num that want to remove
	 */
	public void remAvalNum(int num) {
		avalNum.remove((Integer)num);
	}
	
	/**
	 * return avalNum
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getAvalNum() {
		return avalNum;
	}
	
	/**
	 * return num
	 * @return int
	 */
	public int getNum() {
		return this.num;
	}
	
	/**
	 * set num to the new value
	 * @param num the new value of num
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * add the num to userNum if not in it 
	 * or remove if not in it
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
	 * return userNum
	 * @return ArrayList<Integer>
	 */
	public ArrayList<Integer> getUserNum(){
		return userNum;
	}
}
