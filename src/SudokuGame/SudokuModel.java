package SudokuGame;

import javax.swing.text.BadLocationException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class SudokuModel {

    private Board gameBoard = new Board();

    public boolean isGameSolved() {
        Block[] blocks = gameBoard.getBlocks();

        for (Block block: blocks) {
            if (!block.isBlockSolved())
                return false;
        }

        if (!areRowsSolved(blocks)) {
            return false;
        }
        
        return true;
    }

    public boolean areRowsSolved(Block[] blocks) {
        ArrayList<Integer> row = new ArrayList<>();

        int rowcounter = 0;
        for (Block block: blocks) {
            for (int x = 0; x < 3; x++) {
                row.add(block.getBox(0 + x*3).getValue());
                row.add(block.getBox(1 + x*3).getValue());
                row.add(block.getBox(2 + x*3).getValue());
            }
            rowcounter++;
            if (rowcounter == 3) {
                ArrayList<Integer> numbers = new ArrayList<Integer>();
                for (int i = 1; i < 10; i++) {
                    numbers.add(i);
                }

                for (int rownum: row) {
                    for (int num: numbers) {
                        if (rownum == num) {
                            numbers.remove(num);
                        }
                    }
                }
                if (!numbers.isEmpty()) {
                    return false;
                }
                rowcounter = 0;
            }
        }

        return true;
    }

    public boolean areColumnsSolved(Block[] blocks) {
        return true;
    }

}
