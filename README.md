# Sudoku 🎮


## Navigation

- [Game Info](https://github.com/Hublove/Sudoku-290#game-info)
  - [Game screen](https://github.com/Hublove/Sudoku-290#game-screen) 
  - [Development information](https://github.com/Hublove/Sudoku-290#development-information)
- [Get Started](https://github.com/Hublove/Sudoku-290#get-started)
  - [Download](https://github.com/Hublove/Sudoku-290#download)
  - [Installation](https://github.com/Hublove/Sudoku-290#installation)
- [How to play](https://github.com/Hublove/Sudoku-290#how-to-play)
  - [Game rules](https://github.com/Hublove/Sudoku-290#game-rules)
  - [Controls](https://github.com/Hublove/Sudoku-290#controls)
   - [Contributors](https://github.com/Hublove/Sudoku-290#contributors)
  
- [License](https://github.com/Hublove/Sudoku-290#license)


## Game Info

The classic puzzle game recreated using `Java` and `JavaFX`.

### Game screen

|![Screen 1](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/0A32819822D7487D9AA0A0CF070EEB87/135) |![Screen 2](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/D16FF0FEA2184090BFF8A08014A7A623/167) |
|---------------------------------------------|---------------------------------------------|
|![Screen 3](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/234711F562224A1A9B0A69BE3A8E48E8/155)| ![Screen 4](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/88F8522FC4D74A9FA5B91CBE40D1E2E9/180) |


[[back to top��]](https://github.com/Hublove/Sudoku-290#navigation)

- 
[[back to top��]](https://github.com/Hublove/Sudoku-290#navigation)


## Get started
### Download
You can download the game from here: 
[Download now](https://drive.google.com/file/d/1zRW2ySEBLtMFlv5GSzsgUaTIgL7J-vBu/view?usp=sharing)

### Installation

Before you start the installation, make sure:
	- You have Java JDK installed.
		- `sudo apt-get install openjdk-7-jdk`
	- Or you are running Java(1.8)

1. Open terminal.
2. Use `cd` to navigate to a directory where you want to save the game. 
3. Clone the repository:
	- `git clone https://github.com/Hublove/Sudoku-290.git`

4. Compile the code. 

	-`javac View.java`

5. Run the code.
	-`java View`



[[back to top��]](https://github.com/Hublove/Sudoku-290#navigation)
## How to play
1. Select a box on the board.
	- The box should be highlighted in yellow outer edges. 
2. Input a number(s) from 1 to 9 in the box.
	- Inputting one number will be compared with the solution's number.
	- Inputting more than one number allows you to keep track of future possible moves.
3. Fill the entire board with only one to each box based on the Game Rules.
4. Press the **CHECK** button to check your board with the solution. 
5. Enjoy! 😃


### Game rules
The game follows traditional Sudoku rules.

- The game board has an 9x9  Board.
	- Each each block is divided into nine small grid.You need to fill in the Spaces with Numbers 1-9, so that each number 1-9 appear only once in each row, column, and each blocks.
	
### Controls

- Keyboard
	- Use keys with numbers 1 to 9 to input a number into a box.


- Screen Buttons


|   Buttons           |   function     |
|--------------|---------------------|
| ![image](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/578CED3C36CF402892494A981F3418BF/244)   |   Start a New Game  |
| ![image](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/E515E5D41256468181739109F750050C/245)  | Submit Your Answer    |
| ![image](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/E5AB2F89E381428D8604F79B48B3636E/246) | Go to Instruction Screen |
| ![image](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/32AC1229C47A44E3862D1B45A774C4B4/256)    | Timer     |



 Action| Description of how it works
---|---
|![row 1 col 1](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/BE617DFA67A94E44A0CF4593FD1D9298/326) | Choose a box |
![image](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/0CBB6F63ED31493CA21DDD46E6F71286/327)| Input number 1
|![row 2 col 1](https://note.youdao.com/yws/public/resource/b246b535f6d938f4575d3115e0ce3bcb/xmlnote/18BA192111A04D5D9D6F15A6279F3712/271) | Input other numbers for future moves |

[[back to top��]](https://github.com/Hublove/Sudoku-290#navigation)



## Contributors


- Team Cloud290:
  - Chen Yao
  - Nabeel Rajabali
  - Sebastian Lucas Stanik
  - Seungmin Baek
  - Cassandra Cupryk
  - Jianhao Tian
  
  
## License


MIT License

Copyright (c) 2019 Cloud290

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.




\
\
\
[[back to top��]](https://github.com/Hublove/Sudoku-290#navigation)
