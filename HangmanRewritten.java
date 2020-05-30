//Import Game Modes
//CUSTOM MODE STEP 1: IMPORT HERE
//STEP 2 @ LINE ~94
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
            System.out.println("       HangmanJ v1.0: Main Menu      ");
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

    //Word Management Menu
    private static void manageWordsMenu() {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=====================================");
            System.out.println("     HangmanJ v1.0:  Manage Words    ");
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

    //Game Mode Selection Menu
    private static void gameModeMenu() {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=====================================");
            System.out.println("      HangmanJ v1.0:  Game Modes     ");
            System.out.println("-------------------------------------");
            System.out.println("        1 - Classic (6 Guess)        ");
            System.out.println("        2 - Classic (12 Guess)       ");
            System.out.println("            3 - Unlimited            ");
                                //STEP 2: LIST ADDITIONAL MODES HERE
                                //STEP 3 @ LINE ~113
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
                //STEP 3: ADD ADDITIONAL CASES FOR GAME MODES BELOW
                case 0:
                    closeMenu = true;
                    break;
                default:
                    System.out.println("Try again");
            }
        } while(!closeMenu);
    }
}