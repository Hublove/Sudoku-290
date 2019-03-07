package SudokuGame;

import javax.swing.text.BadLocationException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SudokuModel {

    public Board board = new Board();


    public genNewGame() {

    }


    public boolean isGameSolved() {
        Block[] blocks = board.getBlocks();

        for (Block block: blocks) {
            if (!isBlockSolved(block))
                return false;
        }

        for (int r = 0; r < 9; r++) {
            if (!isRowSolved(this.board, r)) {
                return false;
            }
        }

        for (int c = 0; c < 9; c++) {
            if (!isColumnSolved(this.board, c)) {
                return false;
            }
        }

        return true;
    }

    public boolean isBlockSolved(Block block) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
            for (int num: numbers) {
                if (block.getNum(i) == num) {
                    numbers.remove(num);
                }
            }
        }

        if (!numbers.isEmpty()) {
            return false;
        }

        return true;
    }

    public boolean isRowSolved(Board board, int rowNum) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
            for (int num: numbers) {
                if (board.getNum(rowNum, i) == num) {
                    numbers.remove(num);
                }
            }
        }

        if (!numbers.isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean isColumnSolved(Board board, int colNum) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }

        for (int i = 0; i < 9; i++) {
            for (int num: numbers) {
                if (board.getNum(i, colNum) == num) {
                    numbers.remove(num);
                }
            }
        }

        if (!numbers.isEmpty()) {
            return false;
        }
        return true;
    }

}
