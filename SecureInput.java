import java.util.Scanner;

public class SecureInput {

    //Takes only integer input
    public static int secureInt() {
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        boolean complete = false;
        do {
            try {
                userInput = input.nextInt();
                complete = true;
            } catch (java.util.InputMismatchException e) {
                System.out.println("Please enter a number");
                input.nextLine();
            }
        } while (!complete);
        input.close();
        return userInput;
    }

    //Takes single character input as string
    public static String secureStringChar() {
        Scanner input = new Scanner(System.in);
        String character = "";
        boolean complete = false;
        do {
            if (input.hasNext()) {
                character = input.next();
                input.nextLine();
                if (stringCharacterCheck(character)) {
                    if (character.length() == 1) {
                        complete = true;
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
        } while (!complete);
        character = character.toUpperCase();
        return character;
    }

    //Checks if a string contains only characters
    private static boolean stringCharacterCheck(String str) {
        return ((str != null)
                && (!str.equals(""))
                && (str.matches("^[a-zA-Z]*$")));
    }

}
