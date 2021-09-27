package com.example.ohce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalTime;

public class OhceApplication {

	private Ohce ohce;
	private Writer outputWriter;

	public OhceApplication(Writer outputWriter, String name, LocalTime localTime) {
		this.ohce = new Ohce(localTime, name);
		this.outputWriter = outputWriter;
	}

	public void enter(String inputString) {
		ohce.enter(inputString);
	}

	public void run() throws IOException {
		outputWriter.write(ohce.lastOutput() + "\n");
		outputWriter.flush();
	}

	public static void main(String args[]) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		Writer outputWriter = new PrintWriter(System.out);
		String inputText = "";
		boolean stop = false;

		//
		if (args.length < 1) {
			System.err.println("Should provide one argument\n");
			System.exit(1);
		}

		OhceApplication app = new OhceApplication(outputWriter, args[0], LocalTime.now());

		try {
			outputWriter.flush();
			while (!stop) {
				app.run();
				inputText = reader.readLine();
				app.enter(inputText);

				outputWriter.flush();
				if ("Stop!".equals(inputText)) {
					stop = true;
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(1);
		}
	}

}
