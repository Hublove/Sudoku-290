package SudokuGame;

import javax.swing.text.BadLocationException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class SudokuModel {

    public Board board;

    public SudokuModel() {
        board = new Board();
    }

    public void diGenGame(String diff) {
        Random rand = new Random();
        int toRemove = 0;
        int counter = 0;
        int x = 0, y = 0;

        if (diff == "easy") {
            toRemove = 20;
        } else if (diff == "medium") {
            toRemove = 40;
        } else if (diff == "hard") {
            toRemove = 60;
        }

        while (counter < toRemove) {
            x = rand.nextInt(9);
            y = rand.nextInt(9);

            if (board.getNum(x, y) != -1) {
                board.setNum(x, y, -1);
                counter++;
            }

        }

    }

    public void genNewGame() {
        Random rand = new Random();

        int[] row = new int[9];

        for (int i = 0; i < 9; i++) {
            row[i] = rand.nextInt(9) + 1;
        }

        setRow(board, row, 0);
        shiftRow(row, 3);
        setRow(board, row, 1);
        shiftRow(row, 3);
        setRow(board, row, 2);

        shiftRow(row, 1);
        setRow(board, row, 3);
        shiftRow(row, 3);
        setRow(board, row, 4);
        shiftRow(row, 3);
        setRow(board, row, 5);

        shiftRow(row, 1);
        setRow(board, row, 6);
        shiftRow(row, 3);
        setRow(board, row, 7);
        shiftRow(row, 3);
        setRow(board, row, 8);

    }

    public void setRow(Board board, int[] row, int rowNum) {
        for (int i = 0; i < 9; i++) {
            board.setNum(i, rowNum, row[i]);
        }
    }

    public void shiftRow(int[] row, int amount) {

        if (amount == 3) {
            int[] tempRow = new int[3];

            for (int j = 0; j < 3; j++) {
                tempRow[j] = row[j];
            }

            for (int i = 0; i < 6; i++) {
                row[i] = row[i + 3];
            }

            for (int x = 0; x < 3; x++) {
                row[x + 6] = tempRow[x];
            }
        } else if (amount == 1) {
            int temp = row[0];
            for (int i = 0; i < 8; i++) {
                row[i] = row[i + 1];
            }
            row[8] = temp;
        }

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
                if (board.getNum(i, rowNum) == num) {
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
                if (board.getNum(colNum, i) == num) {
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
