package SudokuGame;

public class Board {

    Block[] blocks;

    public Board() {
        this.blocks = new Block[9];
    }

    public Block[] getBlocks() {
        return this.blocks;
    }

    public Block getBlock(int index) {
        return this.blocks[index];
    }

    public void setBlock(int index, Block block) {
        this.blocks[index] = block;
    }

}
