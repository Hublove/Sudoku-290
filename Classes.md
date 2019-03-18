# Sudoku Classes and Functions


## Directory
- `src` contains all the Java source code
	- `image` contains the PNG versions of the original button images.
	- `image.num` contains the PNG versions of the original number images.
	- `SudokuGame` contains all the classes of the game. 


## Box Class

- The purpose of the Box class is to easily compare the number contained in each Box class with the number stated by the solution. 
- One Box class is visually defined as a square on the gameboard with the background image of a tree trunk. The square may contain no integers, one integer, or more than one integer.
- The `int num` and the `ArrayList<Integer> avalNum` are variables for generating the board based on the rules of Sudoku.


### Box's Variables
| Variable | Variable Definition |
|:---------------------------:|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Image nums[]` | Defines an array of blue number images. |
| `Image cnums[]` | Defines an array of yellow number images. |
| `int num` | Defines the Box number. If the Box’s num is not equal to -1, then the generator has set the num and the user will be unable to modify the num. If the Box’s num is equal to -1, then the user will be able to modify the num. |
| `ArrayList<Integer>userNum` | Defines the user’s numbers currently contained in the Box. If only one number is present then the number will be compared to the solution’s number. If more than one number is present than these numbers represent the player’s possible future moves. |
| `ArrayList<Integer>avalNum` | Defines the numbers still available for the generator to use when constructing the board. |


### Box's Functions
| Function | Function Definition |
|:--------------------------------:|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Box(int num)` | Initializes a class Box containing a num (set by the inputted integer selected by the generator), an empty userNum, and an empty avalNum. This Box class will not be modified by the user. |
| `Box()` | Initializes a class Box containing a non-set num, an empty userNum, and an avalNum containing integers from 1 to 9. This Box class will be modified by the user. |
| `void setNum(int num)` | Sets the Box’s num with the inputted integer. |
| `setUserNum(int num)` | Adds the inputted integer to userNum if userNum does not contain the number. Removes the inputted number from userNum if the userNum does contain the inputted integer. |
| `int getNum()` | Returns the Box’s current num. |
| `ArrayList<Integer>getAvalNum()` | Returns the Box’s current avalNum. |
| `ArrayList<Integer>getUserNum()` | Returns the Box’s current userNum. |
| `void remAvalNum(int num)` | Removes the inputted num from avalNum. |


## Block Class

- One Block class is visually defined as a square on the gameboard surrounded by black lines and containing 9 Boxes. 
- The purpose of the Block class is to easily check if the numbers in the Block are following the rules of Sudoku. 
- The code of Block class is mainly composed of setters and getters from the Box class. 

### Block's Functions
| Function | Function Definition |
|:---------------------------------------------:|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Block()` | Initializes a class Block with 9 empty Box classes. |
| `void setNum(int index, int num)` | Sets the inputted num of the Box at the inputted index. Removes the num from avalNum from all Box classes within the current Block. setNum is used to generate the board. |
| `void setNum(int x, int y, int num)` | Sets the inputted num of the Box at the inputted xy-coordinate. Removes the num from avalNum from all Box classes within the current Block. setNum is used to generate the board. |
| `void setUserNum(int index, int num)` | If the userNum of Box at the inputted index does not contain the inputted num, then the num is added to the userNum. If the userNum of Box at the inputted index contains the inputted num, then the num is removed from the userNum. |
| `void setUserNum(int x, int y, int num)` | If the userNum of Box at the inputted xy-coordinate does not contain the inputted num, then the num is added to the userNum. If the userNum of Box at the inputted xy-coordinate contains the inputted num, then the num is removed from the userNum. |
| `int getNum(int index)` | Returns the num within the Box at the inputted index. |
| `int getNum(int x, int y)` | Returns the num within the Box at the inputted xy-coordinate. |
| `ArrayList<Integer> getAvalNum(int index)` | Returns the avalNum from the Box at the inputted index. |
| `ArrayList<Integer>getAvalNum (int x, int y)` | Returns the avalNum from the Box at the inputted xy-coordinate. |
| `ArrayList<Integer> getUserNum(int index)` | Returns the userNum from the Box at the inputted index. |
| `ArrayList<Integer>getUserNum (int x,int y)` | Returns the userNum from the Box at the inputted xy-coordinate. |
| `void remAvalNum (int index, int num)` | Removes the inputted num from the avalNum of the Box at the inputted index. |
| `void remAvalNum (int x, int y, int num)` | Removes the inputted num from the avalNum of the Box at the inputted xy-coordinate. |



## Board Class
- One Board class is visually defined as a square on the gameboard surrounded by black lines and contains 9 Blocks.
- The purpose of the Board class is to easily check if the numbers on the Board are following the rules of Sudoku regarding columns and rows. 
- The code of Board class is mainly composed of setters and getters from the Box class. 
- The ` void setNum(int x, int y, int num)` and the ` void setUserNum(int x, int y, int num)` are functions for generating the board based on the rules of Sudoku.


### Board's Variables
| Variable       | Variable Definition              |
|----------------|----------------------------------|
| Block blocks[] | An empty array of Block classes. |


### Board's Functions
|                    Function                    | Function Defintion                                                                                                                                                                                                                                    |
|:----------------------------------------------:|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
|                    `Board()`                   | Initializes a class Block with 9 empty Box classes.                                                                                                                                                                                                   |
|              `Block[] getBlocks()`             | Sets the inputted num of the Box at the inputted index. Removes the num from avalNum from all Box classes within the current Block. setNum is used to generate the board.                                                                             |
|      `void setNum (int x, int y, int num)`     | Sets the inputted num for the Box at the inputted xy-coordinate. Removes the num from avalNum at the corresponding row and column.                                                                                                                    |
| `void setUserNum (int x, int y, int num)`      | If the userNum of Box at the inputted xy-coordinate does not contain the inputted num, then the num is added to the userNum. If the userNum of Box at the inputted xy-coordinate contains the inputted num, then the num is removed from the userNum. |
| `int getNum(int x, int y)`                     | Returns the num for the Box at the inputted xy-coordinate.                                                                                                                                                                                            |
| `ArrayList<Integer> getUserNum(int x, int y)`  | Returns the userNum for the Box at the inputted xy-coordinate.                                                                                                                                                                                        |
| `ArrayList<Integer> getUserNum(int x, int y)`  | Returns the avalNum for the Box at the inputted xy-coordinate.                                                                                                                                                                                        |
| `void remAvalNum(int x, int y, int num)`       | Removes the inputted num for the Box at the inputted xy-coordinate.                                                                                                                                                                                   |



## SudokuModel Class
- The SudokuModel class is responsible for managing the data and rules of the application. 
- The SudokuModel is manipulated by the SudokuController, and then the SudokuModel updates the View.


### SudokuModel's Variables
| Variable            | Variable Definition |
|---------------------|---------------------|
| Block blocks[]      | A Board class.      |
| boolean isEditing   |                     |
| boolean editIndex[] |                     |


### SudokuModel's Functions

| Function | Function Definition |
|:--------------------------------------------------:|------------------------------------------------------------------------------------------------------|
| `SudokuModel()` | Initializes SudokuModel class. |
| `void diGenGame(String diff)` | Sets the difficulty of the Board. |
| `void genNewGame()` | Generates a random Board based on the rules of Sudoku. |
| `void setRow(Board board,  int[] row, int rowNum)` |  |
| `void shiftRow (int[] row, int amount)` |  |
| `boolean isInRow (int[] row, int num)` | Returns true if inputted num already exists in row. |
| `boolean isBlockSolved(Block block)` | Returns true if inputted block has one instance of 1 to 9. |
| `boolean isRowSolved (Board board, int rowNum)` | Returns true if row at inputted rowNum has one instance of 1 to 9 on the inputted board. |
| `boolean isColumnSolved (Board board, int colNum)` | Returns true if inputted column at inputted colNum has one instance of 1 to 9 on the inputted board. |
| `boolean isGameSolved()` | Returns true if the game is solved according to the rules of Sudoku. |



## View Class
- The View determines the visual design of the game. 
- The View presents the SudokuModel to the user in a particular format. 










