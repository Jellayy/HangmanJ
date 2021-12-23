#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "utilities/hangman_engine.h"
#include "utilities/hangman_graphics_engine.h"
#include "utilities/secure_input.h"

static void clear_terminal(){
	printf("\033[2J\033[2J");
}

void run_classic_game(){
	int game_over = 0;
	int max_guesses = 6;
	char *guess;

	clear_terminal();
	printf("Classic Game:\n");
	hangman_engine_init();

	do{
		draw_hangman(max_guesses);
		print_game_state();
		printf("Remaining guesses: %d\nEnter your guess: ", max_guesses);
		guess = secure_string();
		if(strlen(guess) == 1){
			if(!hangman_engine_process_guess_char(guess[0])){
				max_guesses--;
			}
			free(guess);
		} else {
			if(!hangman_engine_process_guess_string(guess)){
				max_guesses--;
			}
			free(guess);
		}

		game_over = max_guesses == 0 || !strcmp(hangman_engine_word, hangman_engine_guess_string);
		clear_terminal();
	} while(!game_over);

	draw_hangman(max_guesses);
	print_post_game_state();
	printf("\nEnter any key to return to menu: ");
	fgetc(stdin);
	hangman_engine_exit();
}

