# Extensions of Sudoku Game

## 1. Add Sound Effects and Background Music

- A new class: AudioConrol
	- Variables store all audio files
	- Functions will play and stop audio files
	- Functions will change the volume
	
- Controller
	- Call functions in AudioConrol to play audios at proper time
	
- View
	- Initiallize AudioConrol
	
## 2. Move Images to Seperate Class to Make It Changeable

- A abstract class: SudokuImages
	- Contain all the name of Images
	
- Classes extends SudokuImages
	- Such as DefaultImages
		- Contain all the Images that is using now
	- Other classes contain Images for different styles
	
	
- View
	- A new variable sudokuImages and set it to DefaultImages
	- Setter function to change sudokuImages
	

## 3. Create a Setting Panel

- Modify the theme of the board by:
	- Call setter in View that set the sudokuImages
	
- Change the volume of Sound Effects or Background Music
	- Call functions in AudioConrol
	
- Change the difficulty of the Sudoku game
	- Make View call diGenGame by passing different arguments
	
- View
	- A init funcion similar to initGameStartScene
	
- Controller
	- A new Controller class: settingController
	
## 4. Unlock Feature

- SudokuModel
	- Store information about how many times player played
	
- Setting Panel
	- Make different theme be able to select or not based on the information in SudokuModel
	
- New class: SaveControl
	- Save the information in SudokuModel related to unlock
	
- SudokuController
	- Call SaveControl when a game finished
	
- View
	- Call SaveControl to load saved information when application start
	
## 5. High Score Board

- SudokuModel
	- Store high scores of every difficulty
	
- SaveControl
	- Also save and load high scores
	
- View
	- A init funcion similar to initGameStartScene to change to score board sceen
	
- SudokuController
	- Save the time spent of a game as the scores to SudokuModel when a game finished
