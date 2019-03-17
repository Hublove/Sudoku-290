#Sudoku Classes and Functions



## Box Class

- The purpose of the Box class is to easily compare the number contained in each Box class with the number stated by the solution. 
- One Box class is visually defined as a square on the gameboard with the background image of a tree trunk. The square may contain no integers, one integer, or more than one integer.
- The `int num` and the `ArrayList<Integer> avalNum` are variables for generating the board based on the rules of Sudoku.

| Variable | Variable Definition |
|:--------------------------:|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Image nums[] | Defines an array of blue number images. |
| Image cnums[] | Defines an array of yellow number images. |
| int num | Defines the Box number. If the Box’s num is not equal to -1, then the generator has set the num and the user will be unable to modify the num. If the Box’s num is equal to -1, then the user will be able to modify the num. |
| ArrayList<Integer> userNum | Defines the user’s numbers currently contained in the Box. If only one number is present then the number will be compared to the solution’s number. If more than one number is present than these numbers represent the player’s possible future moves. |
| ArrayList<Integer> avalNum | Defines the numbers still available for the generator to use when constructing the board. |


| Function | Function Definition |
|--------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Box(int num) | Initializes a class Box containing a num (set by the inputted integer selected by the generator), an empty userNum, and an empty avalNum. This Box class will not be modified by the user. |
| Box() | Initializes a class Box containing a non-set num, an empty userNum, and an avalNum containing integers from 1 to 9. This Box class will be modified by the user. |
| void setNum(int num) | Sets the Box’s num with the inputted integer. |
| setUserNum(int num) | Adds the inputted integer to userNum if userNum does not contain the number. Removes the inputted number from userNum if the userNum does contain the inputted integer. |
| int getNum() | Returns the Box’s current num. |
| ArrayList<Integer>getAvalNum() | Returns the Box’s current avalNum. |
| ArrayList<Integer>getUserNum() | Returns the Box’s current userNum. |
| void remAvalNum(int num) | Removes the inputted num from avalNum. |