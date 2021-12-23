#include <stdio.h>

static char *draw_strings[13] = {
	"   _____\n   |   |\n   O   |\n  /|\\  |\n  / \\  |\n_______|\n",
	"   _____\n   |   |\n   O   |\n  /|\\  |\n  /    |\n_______|\n",
	"   _____\n   |   |\n   O   |\n  /|\\  |\n       |\n_______|\n",
	"   _____\n   |   |\n   O   |\n  /|   |\n       |\n_______|\n",
	"   _____\n   |   |\n   O   |\n   |   |\n       |\n_______|\n",
	"   _____\n   |   |\n   O   |\n       |\n       |\n_______|\n",
	"   _____\n   |   |\n       |\n       |\n       |\n_______|\n",
	"   _____\n       |\n       |\n       |\n       |\n_______|\n",
	"        \n       |\n       |\n       |\n       |\n_______|\n",
	"        \n        \n        \n       |\n       |\n_______|\n",
	"        \n        \n        \n        \n        \n_______|\n",
	"        \n        \n        \n        \n        \n_______ \n",
	"        \n        \n        \n        \n        \n        \n"};

void draw_hangman(int value){
	fputs(draw_strings[value], stdout);
}

//EZ
