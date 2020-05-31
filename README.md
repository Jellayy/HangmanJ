# HangmanJ

> The world's first, most advanced, feature rich, powerful, versatile, modular, excusite, java based hangman game engine

Originally a project for a 100-level programming class, terminal-based hangman in java seemed pretty cool. Naturally, in the bore of quarantine, I decided to take it to the next level.

![Recordit GIF](http://g.recordit.co/k4NJ2uiTTW.gif)

If you're intersted in simply playing the game, instructions are below. However, the current focus of this project is much different.

I will not be developing any more modes or user-facing features for this project. Instead, I will be focusing on developing the hangman "game engine" and its supporting parts. As far as game modes and features go, I'd love to see what the community can do with this. I have focused on making it as easy as possible to integrate new modes without having to touch the source code at all. Whether you think you have a great idea for a hangman game or want to get some early experience in cloning and making pull requests in github, I will be reviewing and implementing as many pull requests for new modes and features as posssible. Detailed instructions for this will be below as well.

## Table of Contents

Playing the game:
- [Requirements](#requirements)
- [Installation](#installation)
- [Gameplay](#gameplay)

Community Development:
- [Features](#features)
- [Developing Your Own Game Mode](#developing-your-own-game-mode)
- [Working with HangmanEngine](#working-with-hangmanengine)
- [HangmanGraphicsEngine and other utilities](#hangmangraphicsengine-and-other-utilities)
- [Adding your Game Mode to the Menu](#adding-your-game-mode-to-the-menu)
- [Submitting a pull request](#sumbitting-a-pull-request)
- [Suggestions and Bugs](#suggestions-and-bugs)

---
## Requirements

- Java(TM) SE Runtime Environment (build 14.0.1+7) or higher

## Installation

- Download latest version from releases
- Extract zip
- Run from terminal
```bash
$ java -jar HangmanJ.jar
```

## Gameplay
As of version 1.0, only the base example game modes I have created are available. However, I definitely plan to expand on future releases as people submit their custom game modes. See how to do so for yourself below!

If you still feel like trying terminal hangman out, controls for options are displayed in the menu. You can submit guesses of either a single character, or attempt to guess the whole word, have fun!

---

## Features

 - HangmanEngine handles all aspects of gameplay, including:
      - Choosing a random word from hangmanwords.txt
      - Processing, keeping track of # of guesses and already guessed letters + words
      - Keeps track of and prints game state to terminal
      - Has premade methods that can be called; however, full access is given to private variables through accessors for maximum customization
      - Runs in a non-static context. Developers can run multiple instances of games in their game modes.
      
 - HangmanGraphicsEngine draws ascii hangmen
 - WordManager allows words to be added to hangmanwords.txt from terminal
 - SecureInput gives developers easy access to protected terminal text input
 
 ## Developing your own Game Mode
 
 - Download latest source code from releases or clone using:
 ```bash
 https://github.com/Jellayy/HangmanJ.git
 ```
 - All game modes are stored in `/game`
 - All game modes must have a static `rungame()` method
 ```Java
 package game;
 
 public class ExampleGame {
    public static void runGame() {
        //Game here
    }
 }
 ```
 - All engines and utilities are in `/game/utilities` package
 ```Java
 import game.utilities.HangmanEngine;
 import game.utilities.SecureInput;
 import game.utilities.HangmanGraphicsEngine;
 ```
 - Classic, TwelveGuess, and Unlimited are provided as examples
 
 ## Working with HangmanEngine
 
 - Here is a UML Diagram of all public-facing aspects of the engine as of release 1.0
 ![image](https://raw.githubusercontent.com/Jellayy/HangmanJ/master/images/HangmanEngine%20Public.png)
 
 `HangmanEngine()` - Default Constructor, chooses word, gets things formatted.
 
 `getGuesses()` - Returns number of processed guesses, excludes duplicates.
 
 `getWordLength()` - Returns character length of word being guessed.
 
 `getArrayWord()` - Returns word being guessed in an array split by character.
 
 `getCorrectGuesses()` - Returns an array containing all correct character guesses.
 
 `getIncorrectGuesses()` - Returns string of incorrect guesses, word guesses are separated with "".
 
 `getAllGuesses()` - Returns all character guesses.
 
 `getAllWordGuesses()` - Returns all word guesses.
 
 `getWord()` - Returns word being guessed in plain string.
 
 `printGameState()` - Prints information about current state of game to terminal.
 
 `processGuess(String)` - Takes either a single character or word guess and processes it.
 
 `isGuessed()` - Returns a boolean of whether or not the word has been fully guessed.
 
 `printPostGameState()` - Like `printGameState()` but slightly tweaked.
 
 ## HangmanGraphicsEngine and other utilities
 
 - Full UML diagram (including all private interfaces of HangmanEngine)
 ![image](https://raw.githubusercontent.com/Jellayy/HangmanJ/master/images/Hangman%20UML.png)
 
 - HangmanGraphicsEngine has one static method that can be called to draw ascii hangmen in the terminal
    - `drawHangman(int)` Draws different stages of ascii hangmen from 0 to 12, 0 being fully "drawn"
 - SecureInput offers easy access to protected forms of terminal input through static methods
    - `secureInt()` Takes secure input of an integer
    - `secureString()` Takes single-word String input
    - `secureStringChar()` Takes single-character input in String format
 - WordManager is used by `Hangman.java` to add and view words in `hangmanwords.txt`
 - `hangmanwords.txt` is in `/game/utilities` and by default contains the 1000-ish most popular words from the Merriam-Webster Dictionary
 
 ## Adding your Game Mode to the Menu
 
 - Be sure to revert all steps done here before issuing a pull request
 - All changes made in `Hangman.java`
 - Step 1: import your game mode
```Java
 //Import Game Modes
 import game.Classic;
 import game.Unlimited;
 import game.TwelveGuess;
 import game.ExampleGame; //Your game here
```
 - Step 2: add to menu display
```Java
 System.out.println("=====================================");
 System.out.println("      HangmanJ v1.0:  Game Modes     ");
 System.out.println("-------------------------------------");
 System.out.println("        1 - Classic (6 Guess)        ");
 System.out.println("        2 - Classic (12 Guess)       ");
 System.out.println("            3 - Unlimited            ");
                               //Your game here
 System.out.println("              0 - Back               ");
 System.out.println("=====================================");
```
 - Step 3: add to menu switch
```Java
 case 3:
    Unlimited.runGame();
    closeMenu = true;
    break;
 case 4:
    ExampleGame.runGame(); //Your game here
    closemenu = true;
    break;
```

 ## Submitting a pull request
 - I will be accepting as many pull requests as possible to encorporate as many game modes as I can.
 - Make sure to revert any changes to `Hangman.java` and `hangmanwords.txt` and only submit and added files in `/game`
 
 ## Suggestions and Bugs
 If you have any suggestions or find any issues with the engine or any of my utilities that are stopping you from making your visionary hangman game, feel free to submit a ticket to `Issues`. The goal is to make the most over-the-top engine to support any of your wild ideas, so feel free to shoot me any ideas you may have. I look forward to what you guys can create!
