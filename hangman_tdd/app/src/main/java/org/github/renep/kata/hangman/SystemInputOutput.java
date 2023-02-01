package org.github.renep.kata.hangman;

public class SystemInputOutput implements InputOutput {

	@Override
	public void println(String line) {
		System.out.println(line);
	}
}
