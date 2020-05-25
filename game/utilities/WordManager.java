package game.utilities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class WordManager {

    public static void addWord(String word) {
        try{
            BufferedWriter output = new BufferedWriter(new FileWriter("game/utilities/hangmanWords.txt", true));
            output.newLine();
            output.append(word);
            output.close();
        } catch (java.io.IOException ex) {
            System.out.println("Missing hangmanWords.txt");
        }
    }

    public static void listWords() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("game/utilities/hangmanWords.txt"));
            String line = "";
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (java.io.IOException ex) {
            System.out.println("Missing hangmanWords.txt");
        }
    }

}
