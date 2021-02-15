#include <stdlib.h>
#include <stdio.h>

static int is_digit(char c){
	return c >= '0' && c <= '9';
}

static int is_alpha(char c){
	return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
}

//Takes only integer input
int secure_int(){
	char buffer[1024];
	char *c;
	char cc;
	int complete = 0;

	while ((cc = getchar()) != '\n' && cc != EOF);

	while(!complete){
		fgets(buffer, 1024, stdin);
		c = buffer;
		if(*c == '-'){
			c++;
		}
		if(*c){
			while(*c && (is_digit(*c) || *c == '\n')){
				if(*c == '\n'){
					*c = 0;
					break;
				}
				c++;
			}
			if(!*c){
				complete = 1;
			} else {
				printf("Please enter an integer\n");
			}
		} else {
			printf("Please enter an integer\n");
		}
	}

	return atoi(buffer);
}

//Takes only single word input
char *secure_string(){
	char *buffer;
	char *c;
	char cc;
	int complete = 0;

	buffer = malloc(1024*sizeof(char));
	if(!buffer){
		fprintf(stderr, "Out of memory\n");
		return NULL;
	}

	while(!complete){
		fgets(buffer, 1024, stdin);
		c = buffer;
		if(*c != '\n'){
			while(*c && (is_alpha(*c) || *c == '\n')){
				if(*c == '\n'){
					*c = 0;
					break;
				}
				c++;
			}
			if(!*c){
				complete = 1;
			} else {
				printf("Please enter only characters\n");
			}
		} else {
			printf("Invalid input");
		}
	}

	return buffer;
}

//Takes single character input
char secure_char(){
	char output;
	char cc;

	fseek(stdin, 0, SEEK_END);
	while(!is_alpha((output = fgetc(stdin)))){
		fseek(stdin, 0, SEEK_END);
		printf("\nPlease enter a letter\n");
	}

	printf("\n");

	return output;
}
//LMAO look at how tiny this function is Austin. Java is doodoo and you know it!

