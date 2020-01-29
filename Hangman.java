import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Random;
import java.util.Arrays;

public class Hangman {

    //Main Program
    public static void main(String[] args) {
        //Intro Line
        System.out.println("Hangman - A. Huffman");

        //Chooses word from file
        String[] word = importWord();
        int wordLength = word.length;

        //Create guessing arrays
        String[] correctGuesses = new String[wordLength];
        String incorrectGuesses = "";

        //Format guessing string
        correctGuesses = arrayHangmanFormatter(correctGuesses, wordLength);

        //Game Start
        int counter = 0;
        boolean gameOver = false;
        String guess = "";
        boolean containsGuess = false;
        String allGuesses = "";
        do {

            //Print current game status
            System.out.println("");
            for (int i = 0; i < wordLength; i++) {
                System.out.print(correctGuesses[i] + " ");
            }
            System.out.print("   ");
            System.out.print("Used letters: {" + incorrectGuesses + "}\n");

            //Take Guess
            System.out.print("Enter a letter: ");
            guess = charInput();

            //Processes guess and keeps track of number of guesses
            containsGuess = arraySearcher(word, guess);
            if(containsGuess) {
                if (allGuesses.contains(guess)) {
                    System.out.println("You have already guessed this letter.");
                }
                else {
                    correctGuesses = arrayReplacer(word, correctGuesses, guess);
                    counter++;
                }
            }
            else {
                if (allGuesses.contains(guess)) {
                    System.out.println("You have already guessed this letter.");
                }
                else {
                    incorrectGuesses = incorrectGuesses + guess;
                    counter++;
                }
            }
            allGuesses = allGuesses + guess;

            //Check if game is over
            gameOver = isGameOver(correctGuesses);

        } while (!gameOver);

        //Display post-game stats
        for (int i = 0; i < wordLength; i++) {
            System.out.print(correctGuesses[i] + " ");
            }
        System.out.print("   ");
        System.out.print("Used letters: {" + incorrectGuesses + "}\n");
        System.out.print("You guessed it in " + counter + " tries.");

        }



    //Takes single character string input
    private static String charInput() {
        //initialize scanner and input string
        Scanner input = new Scanner(System.in);
        String character = "";

        //Takes only single character strings
        int validateInput = 0;
        do {
            if (input.hasNext()) {
                character = input.next();
                if (stringCharacterCheck(character)) {
                    if (character.length() == 1) {
                        validateInput = 1;
                    }
                    else {
                        System.out.println("Please enter only one letter");
                    }
                }
                else {
                    System.out.println("Please enter a letter");
                }
            }
            else {
                System.out.println("Invalid input");
            }
        } while (validateInput != 1);

        //Convert input to uppercase and return
        character = character.toUpperCase();
        return character;
    }

    //Checks if a string contains only characters
    private static boolean stringCharacterCheck(String str) {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

    //Imports 10 words from 'hangmanWords.txt' and chooses one to import to program
    private static String[] importWord() {
        String[] allWords = new String[973];
        String line = "";
        String word = "";
        try {
            //Initializes file reader
            FileReader fr = new FileReader("hangmanWords.txt");
            BufferedReader inFile = new BufferedReader(fr);

            //writes file contents to array
            for (int i = 0; i < 973; i++) {
                line = inFile.readLine();
                allWords[i] = line;
            }

            inFile.close();
        }
        catch (IOException ioe) {
            System.out.println("'hangmanWords.txt' Missing");
        }

        //Chooses random word from array and converts to uppercase
        Random rand = new Random();
        int randomNum = rand.nextInt(971 + 1) + 1;
        word = allWords[randomNum];
        word = word.toUpperCase();

        //Converts chosen word to an array
        String[] arrayedWord = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            arrayedWord[i] = Character.toString(word.charAt(i));
        }

        return arrayedWord;
    }

    //Fills an array with underscores for Hangman formatting
    private static String[] arrayHangmanFormatter(String[] array, int length) {
        for (int i = 0; i < length; i++) {
            array[i] = "_";
        }

        return array;
    }

    //Searches string arrays for given guess
    private static boolean arraySearcher(String[] array, String guess) {
        boolean containsGuess = false;
        if(Arrays.asList(array).contains(guess)) {
            containsGuess = true;
        }
        return containsGuess;
    }

    //Replaces guessing array with correctly guessed letters
    private static String[] arrayReplacer(String[] word, String[] guessingArray, String replace) {
        for(int i = 0; i < word.length; i++) {
            if(word[i].equals(replace)) {
                guessingArray[i] = replace;
            }
        }

        return guessingArray;
    }

    //Checks if game is over
    private static boolean isGameOver(String[] guesses) {
        boolean gameOver = true;
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i].equals("_")) {
                gameOver = false;
            }
        }

        return gameOver;
    }
}
