package game;

import game.utilities.HangmanEngine;
import game.utilities.SecureInput;
import game.utilities.HangmanGraphicsEngine;

public class TwelveGuess {
    public static void runGame() {

        //Show Start Screen
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Classic Game:");

        //Initialize Engine
        HangmanEngine game = new HangmanEngine();

        //Start Game
        String guess = "";
        boolean gameOver = false;
        int maxGuesses = 12;
        do {

            HangmanGraphicsEngine.drawHangman(maxGuesses);
            game.printGameState();
            System.out.println("Remaining guesses: " + maxGuesses);

            System.out.print("Enter your guess: ");
            guess = SecureInput.secureString();
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
        System.out.println("\nEnter any key to return to menu: ");
        String returnToMenu = SecureInput.secureString();

    }
}
