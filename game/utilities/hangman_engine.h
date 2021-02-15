#include <stdint.h>

int hangman_engine_process_guess_char(char guess);
int hangman_engine_process_guess_string(char *guess);
void print_post_game_state();
void print_game_state();
void hangman_engine_init();
void hangman_engine_exit();

extern int hangman_engine_guesses;
extern int hangman_engine_incorrect_guesses;
extern int hangman_engine_word_length;
extern uint32_t hangman_engine_all_mask;
extern uint32_t hangman_engine_incorrect_mask;
extern char *hangman_engine_word;
extern char *hangman_engine_guess_string;

