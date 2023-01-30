/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.renep;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

class Hangman {

	String wordToGuess = "hangman";
	int numberCharacters = wordToGuess.length();

	Scanner scanner;

	public Hangman() {
		// Stream to read from the console
		InputStream input = System.in;
		// The scanner scans the input.
		scanner = new Scanner(input);
	}


	public void printStatus(String guessedWord) {
		String message = "Runde 0. Bisher geraten: " + guessedWord + ". Was wählst du für ein Zeichen?";
		System.out.println(message);
	}


	public char askUserToGuessCharacter() {
		// and returns the first character that the user has entered.
		char guessedChar = scanner.next().charAt(0);

		// return the character
		return guessedChar;
	}

	public String getGuessedWord() {
		String guessedWord = "";
		for (int i = 0; i < numberCharacters; i++) {
			guessedWord = guessedWord + "_";
		}
		return guessedWord;
	}


	public String createCurrentGuessedWord(char first, char second) {
		String guessedWord = "";
		for (int i = 0; i < wordToGuess.length(); i++) {
			// i = 0, ch = "h"
			// i = 1, ch = "a"
			// i = 2, ch = "n"

			char ch = wordToGuess.charAt(i);
			if (ch == first) {
				guessedWord = guessedWord + ch;
			} else if (ch == second) {
				guessedWord = guessedWord + ch;
			} else {
				guessedWord = guessedWord + "_";
			}
			// System.out.println(ch);
		}
		return guessedWord;
	}


	public String createCurrentGuessedWord(ArrayList<Character> guessedCharacters) {
		String guessedWord = "";

		System.out.println("guessedCharacters: " + guessedCharacters);

		// wordToGuess == "hangeman"
		for (int i = 0; i < wordToGuess.length(); i++) {
			char currentCharacter = wordToGuess.charAt(i);
			// i = 0, currentCharacter = "h"
			// i = 1, currentCharacter = "a"
			// i = 2, currentCharacter = "n"

			// wenn guessedCharacters wordToGuessCurrentCharacter beinhaltet, dann füge wordToGuessCurrentCharacter zum ergebnis string dazu ansonsten '_'

			/*
				 boolean isIn = guessedCharacters.contains(currentCharacter);
				 char output = '_';
				 if (isIn) {
				 output = currentCharacter;
				 }
			// fügen zum aktuellen guess word den output dazu
			guessedWord = guessedWord + output;
			*/


			if (guessedCharacters.contains(currentCharacter)) {
				guessedWord += currentCharacter;
			} else {
				guessedWord += '_';
			}

		}
		System.out.println("guess word: " + guessedWord);
		return guessedWord;
	}


	void run() {

		System.out.println("length: " + numberCharacters);


		String guessedWord = getGuessedWord(); // generates ________
		printStatus(guessedWord);


		ArrayList<Character> guessedCharacters = new ArrayList<Character>();

		boolean match = wordToGuess == guessedWord;
		int tries = 0;

		while(!match) {
			char guessedChar = askUserToGuessCharacter();
			guessedCharacters.add(guessedChar);
			guessedWord = createCurrentGuessedWord(guessedCharacters);

			match = wordToGuess.equals(guessedWord);

			tries++;
			if (tries >= 10) {
				System.out.println("You have lost! The word was: " + wordToGuess);
				return;
			}
		}

		System.out.println("You have won!");
	}

	void cleanup() {
		scanner.close();
	}

	public static void main(String[] args) {
		Hangman hangman = new Hangman();
		hangman.run();
		hangman.cleanup();
	}


}
