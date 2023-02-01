package org.github.renep.kata.hangman;

import java.util.ArrayList;

public class InputOutputFake implements InputOutput {

	ArrayList<String> output = new ArrayList<String>();

	int currentOutputLine = 0;

	public void println(String line) {
		output.add(line);
	}

	public String getNextLine() {
		if (output.size() > currentOutputLine) {
			String result = output.get(currentOutputLine);
			currentOutputLine++;
			return result;
		}
		return null;
	}
}
