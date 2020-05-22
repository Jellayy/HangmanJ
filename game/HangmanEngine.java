package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class HangmanEngine {

    private final String[] arrayWord;
    private final int wordLength;
    private int guesses;
    private String[] correctGuesses;
    private String incorrectGuesses = "";
    private String allGuesses = "";

    //Constructor
    public HangmanEngine() {
        arrayWord = importWord();
        wordLength = arrayWord.length;
        guesses = 0;
        correctGuesses = arrayHangmanFormatter(wordLength);
    }

    //Accessors
    public int getGuesses() {
        return guesses;
    }
    public int getWordLength() {
        return wordLength;
    }
    public String[] getArrayWord() {
        return arrayWord;
    }
    public String[] getCorrectGuesses() {
        return correctGuesses;
    }
    public String getIncorrectGuesses() {
        return incorrectGuesses;
    }

    //Default Methods
    public void printGameState() {
        for (int i = 0; i < wordLength; i++) {
            System.out.print(correctGuesses[i] + " ");
        }
        System.out.print("   ");
        System.out.print("Used letters: {" + incorrectGuesses + "}\n");
    }

    public boolean processGuess(String guess) {
        boolean containsGuess = arraySearcher(arrayWord, guess);
        if(allGuesses.contains(guess)) {
            System.out.println("You have already guessed this letter.");
            return false;
        }
        else {
            if(containsGuess) {
                correctGuesses = arrayReplacer(arrayWord, correctGuesses, guess);
                guesses++;
                allGuesses = allGuesses + guess;
                return true;
            }
            else {
                incorrectGuesses = incorrectGuesses + guess;
                guesses++;
                allGuesses = allGuesses + guess;
                return false;
            }
        }
    }

    public boolean isGameOver() {
        boolean gameOver = true;
        for (int i = 0; i < correctGuesses.length; i++) {
            if (correctGuesses[i].equals("_")) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    public void printPostGameState() {
        for (int i = 0; i < wordLength; i++) {
            System.out.print(correctGuesses[i] + " ");
        }
        System.out.print("   ");
        System.out.print("Used letters: {" + incorrectGuesses + "}\n");
        System.out.print("You guessed it in " + guesses + " tries.");
    }

    //Private Methods
    private static String[] importWord() {
        //Imports 10 words from 'hangmanWords.txt' and chooses one to import to program
        String[] allWords = new String[973];
        String line = "";
        String word = "";
        try {
            //Initializes file reader
            FileReader fr = new FileReader("game/hangmanWords.txt");
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
    private static String[] arrayHangmanFormatter(int length) {
        //Fills an array with underscores for Hangman formatting
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "_";
        }

        return array;
    }
    private static boolean arraySearcher(String[] array, String guess) {
        //Searches string arrays for given guess
        boolean containsGuess = false;
        if(Arrays.asList(array).contains(guess)) {
            containsGuess = true;
        }
        return containsGuess;
    }
    private static String[] arrayReplacer(String[] word, String[] guessingArray, String replace) {
        //Replaces guessing array with correctly guessed letters
        for(int i = 0; i < word.length; i++) {
            if(word[i].equals(replace)) {
                guessingArray[i] = replace;
            }
        }

        return guessingArray;
    }

}
