package SudokuGame;

import java.util.ArrayList;

public class Block {

    Box[] boxes;

    public Block(){
        boxes = new Box[9];
    }

    public Box[] getBoxes(){
        return this.boxes;
    }

    public Box getBox(int index) {
        return this.boxes[index];
    }

    public void setBox(int index, int value) {
        this.boxes[index] = new Box(value);
    }

    public boolean isBlockSolved() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }


        for (Box box: this.boxes) {
            for (int num: numbers) {
                if (box.getValue() == num) {
                    numbers.remove(num);
                }
            }
        }

        if (numbers.isEmpty())
            return true;

        return false;
    }



}
