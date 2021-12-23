#include <stdlib.h>
#include <stdio.h>
#include "game/utilities/secure_input.h"
#include "game/utilities/word_manager.h"

static void clear_terminal(){
	printf("\033[2J\033[2J");
}

void run_classic_game();
void run_twelve_guesses_game();
void run_unlimited_game();

void manage_words_menu(){
	int close_menu = 0;
	char *str;

	do{
		clear_terminal();
		printf("=====================================\n");
		printf("     HangmanJ v1.1:  Manage Words    \n");
		printf("          Copyright Ben Jones        \n");
		printf("-------------------------------------\n");
		printf("     Words can also be edited in:    \n");
		printf("   game/utilities/hangmanWords.txt   \n");
		printf("-------------------------------------\n");
		printf("            A - Add Word             \n");
		printf("           V - View Words            \n");
		printf("              B - Back               \n");
		printf("=====================================\n");
		printf("Choose: ");
		switch(secure_char()){
			case 'A':
				printf("Enter Word: ");
				str = secure_string();
				add_word(str);
				free(str);
				break;
			case 'V':
				list_words();
				printf("Enter any character to go back: ");
				secure_char();
				break;
			case 'B':
				close_menu = 1;
				break;
			default:
				printf("Try again\n");
				break;
		}
	} while(!close_menu);
}

void game_mode_menu(){
	int close_menu = 0;

	do{
		clear_terminal();
		printf("=====================================\n");
		printf("      HangmanJ v1.1:  Game Modes     \n");
		printf("          Copyright Ben Jones        \n");
		printf("-------------------------------------\n");
		printf("        1 - Classic (6 Guess)        \n");
		printf("        2 - Classic (12 Guess)       \n");
		printf("            3 - Unlimited            \n");
		printf("              0 - Back               \n");
		printf("=====================================\n");
		printf("Choose: ");
		switch(secure_int()){
			case 1:
				run_classic_game();
				close_menu = 1;
				break;
			case 2:
				run_twelve_guesses_game();
				close_menu = 1;
				break;
			case 3:
				run_unlimited_game();
				close_menu = 1;
				break;
			case 0:
				close_menu = 1;
				break;
			default:
				printf("Try again\n");
		}
	} while(!close_menu);
}

int main(int argc, char **argv){
	int close_menu = 0;

	do{
		clear_terminal();
		printf("=====================================\n");
		printf("       HangmanJ v1.1: Main Menu      \n");
		printf("          Copyright Ben Jones        \n");
		printf("-------------------------------------\n");
		printf("            P - Play Game            \n");
		printf("           M - Manage Words          \n");
		printf("              E - Exit               \n");
		printf("=====================================\n");
		printf("Choose: ");
		switch(secure_char()){
			case 'P':
				game_mode_menu();
				break;
			case 'M':
				manage_words_menu();
				break;
			case 'E':
				printf("Exiting...\n");
				close_menu = 1;
				break;
			default:
				printf("Try again\n");
				break;
		}
	} while(!close_menu);

	return 0;
}

