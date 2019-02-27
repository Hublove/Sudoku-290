package SudokuGame;

import java.util.ArrayList;

import javafx.scene.image.Image;

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
	
	public Box(int num) {
		this.num = num;
		userNum = new ArrayList<>();
		avalNum = new ArrayList<>();
	}
	
	public Box() {
		this.num = -1;
		userNum = new ArrayList<>();
		avalNum = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			avalNum.add(i);
		}
	}
	
	public void remAvalNum(int num) {
		avalNum.remove((Integer)num);
	}
	
	public ArrayList<Integer> getAvalNum() {
		return avalNum;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public void setUserNum(int num) {
		if (userNum.indexOf(num) < 0) {
			userNum.add(num);
			return;
		}
		userNum.remove((Integer)num);
	}
	
	public ArrayList<Integer> getUserNum(){
		return userNum;
	}
}
