#include <stdlib.h>
#include <stdio.h>

int add_word(char *word){
	FILE *fp;

	fp = fopen("game/utilities/hangmanWords.txt", "a");
	if(!fp){
		fprintf(stderr, "Could not open hangmanWords.txt\n");
		return 1;
	}

	fputs(word, fp);
	fputc('\n', fp);

	fclose(fp);

	return 0;
}

int list_words(){
	FILE *fp;
	int size;
	char *buffer;

	fp = fopen("game/utilities/hangmanWords.txt", "r");
	if(!fp){
		fprintf(stderr, "Could not open hangmanWords.txt\n");
		return 1;
	}

	fseek(fp, 0, SEEK_END);
	size = ftell(fp);
	fseek(fp, 0, SEEK_SET);
	buffer = calloc((size + 1), sizeof(char));
	if(!buffer){
		fprintf(stderr, "Out of memory\n");
		return 1;
	}
	fread(buffer, sizeof(char), size, fp);
	fclose(fp);

	fputs(buffer, stdout);
	fputc('\n', stdout);

	free(buffer);

	return 0;
}
