package SudokuGame;

import java.util.ArrayList;

public class Board {
	Block blocks[];
	
	public Board() {
		this.blocks = new Block[9];
		for (int i = 0; i < 9; i++) {
			blocks[i] = new Block();
		}
	}
	
	public int getNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getNum((x % 3) + (y % 3) * 3);
	}
	
	public void setNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setNum((x % 3) + (y % 3) * 3, num);
		for (int i = 0; i < 9; i ++) {
			remAvalNum(i,y,num);
			remAvalNum(x,i,num);
		}
	}
	
	public void remAvalNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].remAvalNum((x % 3) + (y % 3) * 3, num);
	}
	
	public ArrayList<Integer> getAvalNum(int x, int y) {
		return this.blocks[(x / 3) + (y / 3) * 3].getAvalNum((x % 3) + (y % 3) * 3);
	}
	
	public void setUserNum(int x, int y, int num) {
		this.blocks[(x / 3) + (y / 3) * 3].setUserNum((x % 3) + (y % 3) * 3, num);
	}
	
	public ArrayList<Integer> getUserNum(int x, int y){
		return this.blocks[(x / 3) + (y / 3) * 3].getUserNum((x % 3) + (y % 3) * 3);
	}
}
