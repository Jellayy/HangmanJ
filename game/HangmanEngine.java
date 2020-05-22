package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class HangmanEngine {

    private final String[] word;
    private final int wordLength;
    private int guesses;
    private String[] correctGuesses;
    private String incorrectGuesses;

    //Constructor
    public HangmanEngine() {
        word = importWord();
        wordLength = word.length;
        guesses = 0;
        correctGuesses = arrayHangmanFormatter(wordLength);
    }

    //Returns number of guesses
    public int getGuesses() {
        return guesses;
    }

    //Imports 10 words from 'hangmanWords.txt' and chooses one to import to program
    private static String[] importWord() {
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

    //Fills an array with underscores for Hangman formatting
    private static String[] arrayHangmanFormatter(int length) {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "_";
        }

        return array;
    }

}
