package SudokuGame;

import java.util.ArrayList;

public class Block {

	Box boxs[];
	
	public Block() {
		this.boxs = new Box[9];
		for (int i = 0; i < 9; i++) {
			boxs[i] = new Box();
		}
	}
	
	public int getNum(int index) {
		return this.boxs[index].getNum();
	}
	
	public int getNum(int x, int y) {
		return getNum(x + y * 3);
	}
	
	public void setNum(int index, int num) {
		this.boxs[index].setNum(num);
		for (int i = 0; i < 9; i ++) {
			remAvalNum(i,num);
		}
	}
	
	public void setNum(int x, int y, int num) {
		setNum(x + y * 3, num);
	}
	
	public void remAvalNum(int index, int num) {
		this.boxs[index].remAvalNum(num);
	}
	
	public void remAvalNum(int x, int y, int num) {
		remAvalNum(x + y * 3, num);
	}
	
	public ArrayList<Integer> getAvalNum(int index) {
		return this.boxs[index].getAvalNum();
	}
	
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return getAvalNum(x + y * 3);
	}
	
	public void setUserNum(int index, int num) {
		this.boxs[index].setUserNum(num);
	}
	
	public void setUserNum(int x, int y, int num) {
		setUserNum(x + y * 3, num);
	}
	
	public ArrayList<Integer> getUserNum(int index){
		return this.boxs[index].getUserNum();
	}
	
	public ArrayList<Integer> getUserNum(int x, int y){
		return getUserNum(x + y * 3);
	}
}
