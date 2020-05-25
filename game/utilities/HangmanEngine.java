package game.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class HangmanEngine {

    private final String[] arrayWord;
    private final int wordLength;
    private int guesses;
    private String[] correctGuesses;
    private String incorrectGuesses = "";
    private String allGuesses = "";
    private ArrayList<String> allWordGuesses;
    private String word = "";

    //Constructor
    public HangmanEngine() {
        arrayWord = importWord();
        wordLength = arrayWord.length;
        guesses = 0;
        correctGuesses = arrayHangmanFormatter(wordLength);
        convertArrayedWord();
        this.allWordGuesses = new ArrayList<String>();
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
        if(guess.length() == 1) {
            boolean containsGuess = arraySearcher(arrayWord, guess);
            if (allGuesses.contains(guess)) {
                System.out.println("You have already guessed this letter.");
                return true;
            }
            else {
                if (containsGuess) {
                    correctGuesses = arrayReplacer(arrayWord, correctGuesses, guess);
                    guesses++;
                    allGuesses = allGuesses + guess;
                    return true;
                } else {
                    incorrectGuesses = incorrectGuesses + guess;
                    guesses++;
                    allGuesses = allGuesses + guess;
                    return false;
                }
            }
        }
        else {
            if(allWordGuesses.contains(guess)) {
                System.out.println("You have already guessed this word.");
                return true;
            }
            else {
                if(word.equals(guess)) {
                    for(int i = 0; i < arrayWord.length; i++) {
                        correctGuesses = arrayReplacer(arrayWord, correctGuesses, arrayWord[i]);
                    }
                    guesses++;
                    allWordGuesses.add(guess);
                    return true;
                }
                else {
                    incorrectGuesses = incorrectGuesses + "\"" + guess + "\"";
                    guesses++;
                    allWordGuesses.add(guess);
                    return false;
                }
            }
        }
    }

    public boolean isGuessed() {
        boolean gameOver = true;
        for (int i = 0; i < correctGuesses.length; i++) {
            if (correctGuesses[i].equals("_")) {
                gameOver = false;
            }
        }
        return gameOver;
    }

    public void printPostGameState() {
        if(isGuessed()) {
            System.out.println("YOU WIN!");
            for (int i = 0; i < wordLength; i++) {
                System.out.print(correctGuesses[i] + " ");
            }
            System.out.print("   ");
            System.out.print("Used letters: {" + incorrectGuesses + "}\n");
            System.out.print("You guessed it in " + guesses + " tries.");
        }
        else {
            System.out.println("Better luck next time");
            for (int i = 0; i < wordLength; i++) {
                System.out.print(correctGuesses[i] + " ");
            }
            System.out.print("   ");
            System.out.print("Used guesses: {" + incorrectGuesses + "}\n");
            System.out.println("The word was: " + word);
            System.out.print("You used " + guesses + " tries.");
        }
    }

    //Private Methods
    private static String[] importWord() {
        //Imports 10 words from 'hangmanWords.txt' and chooses one to import to program
        ArrayList<String> allWordsList = new ArrayList<String>();
        String line = "";
        String word = "";
        try {
            //Initializes file reader
            FileReader fr = new FileReader("game/utilities/hangmanWords.txt");
            BufferedReader br = new BufferedReader(fr);

            //Writes words from file to arraylist
            while((line = br.readLine()) != null) {
                allWordsList.add(line);
            }

            br.close();
        }
        catch (IOException ioe) {
            System.out.println("'hangmanWords.txt' Missing");
        }
        //Chooses random word from array and converts to uppercase
        Random rand = new Random();
        int randomNum = rand.nextInt(allWordsList.size()) + 1;
        word = allWordsList.get(randomNum);
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
    private void convertArrayedWord() {
        for (int i = 0; i < wordLength; i++) {
            word = word + arrayWord[i];
        }
    }

}
