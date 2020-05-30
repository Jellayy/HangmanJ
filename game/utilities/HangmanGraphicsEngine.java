package game.utilities;

public class HangmanGraphicsEngine {
    public static void drawHangman(int value) {
        if(value == 0) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("  /|\\  |");
            System.out.println("  / \\  |");
            System.out.println("_______|");
        }
        else if(value == 1) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("  /|\\  |");
            System.out.println("  /    |");
            System.out.println("_______|");
        }
        else if(value == 2) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("  /|\\  |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 3) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("  /|   |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 4) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("   |   |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 5) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("   O   |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 6) {
            System.out.println("   _____");
            System.out.println("   |   |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 7) {
            System.out.println("   _____");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 8) {
            System.out.println("        ");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 9) {
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("       |");
            System.out.println("       |");
            System.out.println("_______|");
        }
        else if(value == 10) {
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("_______|");
        }
        else if(value == 11) {
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("_______ ");
        }
        else {
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
            System.out.println("        ");
        }
    }
}
