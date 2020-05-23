package game;

import game.utilities.HangmanEngine;
import game.utilities.SecureInput;
import game.utilities.HangmanGraphicsEngine;

public class Classic {
    public static void runGame() {

        //Show Start Screen
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Classic Game:");

        //Initialize Engine
        HangmanEngine game = new HangmanEngine();

        //Start Game
        String guess = "";
        boolean gameOver = false;
        int maxGuesses = 6;
        do {

            HangmanGraphicsEngine.drawHangman(maxGuesses);
            game.printGameState();
            System.out.println("Remaining guesses: " + maxGuesses);

            System.out.print("Enter a letter: ");
            guess = SecureInput.secureStringChar();
            if(!game.processGuess(guess)) {
                maxGuesses--;
            }

            if (maxGuesses == 0) {
                gameOver = true;
            }
            if (game.isGuessed()) {
                gameOver = true;
            }

            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        } while(!gameOver);

        HangmanGraphicsEngine.drawHangman(maxGuesses);
        game.printPostGameState();

    }
}
