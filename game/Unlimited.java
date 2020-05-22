package game;

import game.utilities.HangmanEngine;
import game.utilities.SecureInput;

public class Unlimited {
    public static void runGame(){

        //Show Start Screen
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Unlimited Game:");

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

            gameOver = game.isGuessed();

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        } while(!gameOver);

        game.printPostGameState();

    }
}
