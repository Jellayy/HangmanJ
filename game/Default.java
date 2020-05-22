package game;

import game.utilities.SecureInput;

public class Default {
    public static void runGame(){

        //Show Start Screen
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Default Game:");

        //Initialize Engine
        HangmanEngine game = new HangmanEngine();

        //Start Game
        String guess = "";
        boolean gameOver = false;
        do {

            game.printGameState();

            System.out.print("Enter a letter: ");
            guess = SecureInput.secureStringChar();
            game.processGuess(guess);

            gameOver = game.isGameOver();

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        } while(!gameOver);

        game.printPostGameState();

    }
}
