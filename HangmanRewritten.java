// Import game modes here:
import game.Classic;
import game.Unlimited;
import game.TwelveGuess;

//Other imports
import game.utilities.SecureInput;
import game.utilities.WordManager;

public class HangmanRewritten {

    //Main Menu
    public static void main(String[] args) {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=====================================");
            System.out.println("     HangmanJ Rewrite: Main Menu     ");
            System.out.println("-------------------------------------");
            System.out.println("            P - Play Game            ");
            System.out.println("           M - Manage Words          ");
            System.out.println("              E - Exit               ");
            System.out.println("=====================================");
            System.out.print("Choose: ");
            String input = SecureInput.secureStringChar();
            switch (input) {
                case "P":
                    gameModeMenu();
                    break;
                case "M":
                    manageWordsMenu();
                    break;
                case "E":
                    System.out.println("Exiting...");
                    closeMenu = true;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        } while(!closeMenu);
    }

    private static void manageWordsMenu() {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=====================================");
            System.out.println("    HangmanJ Rewrite: Manage Words   ");
            System.out.println("-------------------------------------");
            System.out.println("     Words can also be edited in:    ");
            System.out.println("   game/utilities/hangmanWords.txt   ");
            System.out.println("-------------------------------------");
            System.out.println("            A - Add Word             ");
            System.out.println("           V - View Words            ");
            System.out.println("              B - Back               ");
            System.out.println("=====================================");
            System.out.print("Choose: ");
            String input = SecureInput.secureStringChar();
            switch (input) {
                case "A":
                    System.out.println("Enter Word: ");
                    WordManager.addWord(SecureInput.secureString());
                    break;
                case "V":
                    WordManager.listWords();
                    System.out.println("Enter any character to go back: ");
                    String goBack = SecureInput.secureString();
                    break;
                case "B":
                    closeMenu = true;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        } while(!closeMenu);
    }

    private static void gameModeMenu() {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=====================================");
            System.out.println("     HangmanJ Rewrite: Game Modes    ");
            System.out.println("-------------------------------------");
            System.out.println("        1 - Classic (6 Guess)        ");
            System.out.println("        2 - Classic (12 Guess)       ");
            System.out.println("            3 - Unlimited            ");
            System.out.println("              0 - Back               ");
            System.out.println("=====================================");
            System.out.print("Choose: ");
            int input = SecureInput.secureInt();
            switch (input) {
                case 1:
                    Classic.runGame();
                    closeMenu = true;
                    break;
                case 2:
                    TwelveGuess.runGame();
                    closeMenu = true;
                    break;
                case 3:
                    Unlimited.runGame();
                    closeMenu = true;
                    break;
                case 0:
                    closeMenu = true;
                    break;
                default:
                    System.out.println("Try again");
            }
        } while(!closeMenu);
    }


}