#include <stdlib.h>
#include <stdio.h>
#include <stdint.h>
#include <string.h>
#include <time.h>

int hangman_engine_guesses;
int hangman_engine_incorrect_guesses;
int hangman_engine_word_length;
uint32_t hangman_engine_all_mask;
uint32_t hangman_engine_incorrect_mask;
char *hangman_engine_word;
char *hangman_engine_guess_string;

static void to_upper_case(char *c){
	while(*c){
		if(*c < 'A' || *c > 'Z'){
			*c += 'A' - 'a';
		}
		c++;
	}
}

static void print_guesses(uint32_t guesses){
	char c = 'A';

	while(c <= 'Z'){
		if(guesses&1){
			printf("%c ", c);
		}
		guesses >>= 1;
		c++;
	}
}

static char *import_word(){
	FILE *fp;
	int size;
	char *file_buffer;
	char *output;
	char *c;
	char *start;
	int num_words = 1;
	int rand_word;

	//Read the entire file
	fp = fopen("game/utilities/hangmanWords.txt", "r");
	if(!fp){
		fprintf(stderr, "hangmanWords.txt Missing\n");
		return NULL;
	}

	fseek(fp, 0, SEEK_END);
	size = ftell(fp);
	fseek(fp, 0, SEEK_SET);
	file_buffer = calloc(size + 1, sizeof(char));
	output = calloc(1024, sizeof(char));
	if(!file_buffer || !output){
		fprintf(stderr, "Out of memory\n");
		return NULL;
	}
	fread(file_buffer, sizeof(char), size, fp);
	fclose(fp);

	//Determine the number of words in the words list
	c = file_buffer;
	while(*c){
		if(*c == '\n'){
			num_words++;
		}
		c++;
	}
	
	//Chooses a random word
	rand_word = rand()%num_words;

	//Copies a random word into the output
	c = file_buffer;
	while(rand_word){
		if(*c == '\n'){
			rand_word--;
		}
		c++;
	}
	start = c;
	while(*c && *c != '\n' && c - start < 1023){
		c++;
	}

	memcpy(output, start, c - start);
	free(file_buffer);
	to_upper_case(output);

	return output;
}

static int guess_replace(char *word, char *revealed, char guess){
	int output = 0;

	while(word && *word){
		if(*word == guess){
			*revealed = guess;
			output = 1;
		}
		word++;
		revealed++;
	}

	return output;
}

int hangman_engine_process_guess_char(char guess){
	if(guess < 'A' || guess > 'Z'){
		guess += 'A' - 'a';
	}
	if(hangman_engine_all_mask&(1<<(guess - 'A'))){
		printf("You have already guessed this letter.\n");
		return 1;
	} else {
		hangman_engine_guesses++;
		hangman_engine_all_mask |= 1<<(guess - 'A');
		if(guess_replace(hangman_engine_word, hangman_engine_guess_string, guess)){
			return 1;
		} else {
			hangman_engine_incorrect_guesses++;
			hangman_engine_incorrect_mask |= 1<<(guess - 'A');
			return 0;
		}
	}
}

int hangman_engine_process_guess_string(char *guess){
	to_upper_case(guess);
	if(!strcmp(guess, hangman_engine_word)){
		strcpy(hangman_engine_guess_string, hangman_engine_word);
		hangman_engine_guesses++;
		return 1;
	} else {
		hangman_engine_incorrect_guesses++;
		return 0;
	}
}

void print_post_game_state(){
	if(!strcmp(hangman_engine_word, hangman_engine_guess_string)){
		printf("YOU WIN!\n%s   Used letters: {", hangman_engine_word);
		print_guesses(hangman_engine_incorrect_mask);
		printf("}\nYou guessed it in %d tries.\n", hangman_engine_guesses);
	} else {
		printf("Better luck next time\n%s   Used letters: {", hangman_engine_guess_string);
		print_guesses(hangman_engine_incorrect_mask);
		printf("}\nThe word was: %s\n You used %d tries.\n", hangman_engine_word, hangman_engine_guesses);
	}
}

void print_game_state(){
	printf("%s   Used letters: {", hangman_engine_guess_string);
	print_guesses(hangman_engine_incorrect_mask);
	printf("}\n");
}

void hangman_engine_init(){
	hangman_engine_word = import_word();
	if(!hangman_engine_word){
		exit(1);
	}
	hangman_engine_word_length = strlen(hangman_engine_word);
	hangman_engine_guesses = 0;
	hangman_engine_guess_string = calloc(hangman_engine_word_length + 1, sizeof(char));
	if(!hangman_engine_guess_string){
		fprintf(stderr, "Out of memory\n");
		exit(1);
	}
	memset(hangman_engine_guess_string, '_', hangman_engine_word_length);
	hangman_engine_all_mask = 0;
	hangman_engine_incorrect_mask = 0;
}

void hangman_engine_exit(){
	free(hangman_engine_guess_string);
}
