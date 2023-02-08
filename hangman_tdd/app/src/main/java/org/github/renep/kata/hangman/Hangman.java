/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.github.renep.kata.hangman;



public class Hangman {
	private final InputOutput io;


	private String wordToGuess = "hangman";

	public Hangman(InputOutput io) {
		this.io = io;
	}

	public static void main(String[] args) {
		new Hangman(new SystemInputOutput()).run();
	}

	public void run() {
		String guessedWord = generateGuessedWord();

		io.println("Runde 0. Bisher geraten: " + guessedWord + ". Was wählst du für ein Zeichen?");
	}

	String generateGuessedWord() {
		String guessedWord = "_____";
		if (wordToGuess.length() == 10) {
			guessedWord = "__________";
		} else if (wordToGuess.length() == 20) {
			guessedWord = "____________________";
		} else if (wordToGuess.length() == 7) {
			guessedWord = "_______";
		} else if (wordToGuess.length() == 6) {
			guessedWord = "______";
		}
		return guessedWord;
	}
	public void setWordToGuess(String wordToGuess) {
		if (wordToGuess != null) {
			this.wordToGuess = wordToGuess;
		}
	}
}
