# Extensions of Sudoku Game

## 1. Add Sound Effects and Background Music

- A new class: AudioControl
	- Variables can store audio files.
	- Functions can play and stop audio files.
	- Functions can change the volume.
	
- Controller
	- Call functions in AudioControl to play audio files at proper time.
	
- View
	- Initialize AudioControl.
	
## 2. Move Images to Seperate Class to Make It Changeable

- Create an abstract class called SudokuImages.
	- Contain all the name of Images.
	
- Classes inherit from SudokuImages.
	- DefaultImages
		- Contain all the images that are being used.
	
- View
	- Create a new variable sudokuImages and set it to DefaultImages.
	- Create a setter function to change sudokuImages.
	
## 3. Create a Setting Panel

- Modify the theme of the board by:
	- Calling setter in View to set different sudokuImages according to level of difficulty.
	
- Change the volume of Sound Effects or Background Music
	- Call functions in AudioControl.
	
- Change the difficulty of the sudoku game
	- Have View call diGenGame to generate different difficulty settings.
	
- View
	- A init function similar to initGameStartScene.
	
- Controller
	- A new Controller class: settingController
	
## 4. Unlock Feature

- SudokuModel
	- Store information about how many times player played.
	
- Setting Panel
	- Have different selectable themes.
		
- New class: SaveControl
	- Save the information in SudokuModel related to unlocking new features.
	
- SudokuController
	- Call SaveControl when a game is finished.
	
- View
	- Call SaveControl to load saved information when the application starts.
	
## 5. High Score Board

- SudokuModel
	- Store high scores for every difficulty.
	
- SaveControl
	- Saves and loads high scores.
	
- View
	- A init funcion similar to initGameStartScene to change to score board screen.
	
- SudokuController
	- Save the time spent of a game as the scores to SudokuModel when a game finished.
