import game.Classic;
import game.utilities.SecureInput;

public class HangmanRewritten {

    //Main Menu
    public static void main(String[] args) {
        boolean closeMenu = false;
        do {
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("=================================");
            System.out.println("   HangmanJ Rewrite: Main Menu   ");
            System.out.println("---------------------------------");
            System.out.println("          P - Play Game          ");
            System.out.println("         M - Manage Words        ");
            System.out.println("            E - Exit             ");
            System.out.println("=================================");
            System.out.print("Choose: ");
            String input = SecureInput.secureStringChar();
            switch (input) {
                case "P":
                    System.out.println("Play Game...");
                    Classic.runGame();
                    break;
                case "M":
                    System.out.println("Manage Words...");
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

}