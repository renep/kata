package org.github.renep.kata.hangman;

import java.util.ArrayList;
import java.util.function.Consumer;

public class InputOutputFake implements InputOutput {

	public record PrintData(String line, int count) {}

	public boolean characterWasRead = false;
	ArrayList<String> output = new ArrayList<String>();

	public Consumer<PrintData> printlnConsumer;
	private int numberOfPrintlnCalls = 0;

	int currentOutputLine = 0;

	public void println(String line) {
		output.add(line);
		if (printlnConsumer != null) {
			var data = new PrintData(line, numberOfPrintlnCalls);
			printlnConsumer.accept(data);
		}
		numberOfPrintlnCalls += 1;
	}

	@Override
	public char readChar() {
		characterWasRead = true;
		return 0;
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
