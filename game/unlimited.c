#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "utilities/hangman_engine.h"
#include "utilities/hangman_graphics_engine.h"
#include "utilities/secure_input.h"

static void clear_terminal(){
	printf("\033[2J\033[2J");
}

void run_unlimited_game(){
	int game_over = 0;
	char *guess;

	clear_terminal();
	printf("Unlimited Game:\n");
	hangman_engine_init();

	do{
		print_game_state();
		printf("Enter a letter: ");
		guess = secure_string();
		if(strlen(guess) == 1){
			free(guess);
		} else {
			free(guess);
		}

		game_over = !strcmp(hangman_engine_word, hangman_engine_guess_string);
		clear_terminal();
	} while(!game_over);

	print_post_game_state();
	printf("\nEnter any key to return to menu: ");
	fgetc(stdin);
	hangman_engine_exit();
}

