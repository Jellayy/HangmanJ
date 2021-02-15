default:
	gcc hangman.c game/classic.c game/twelve_guess.c game/unlimited.c game/utilities/word_manager.c game/utilities/secure_input.c game/utilities/hangman_graphics_engine.c game/utilities/hangman_engine.c -o hangman

clean:
	rm hangman
