package com.example.ohce;

import java.time.LocalTime;

public class Ohce {

	private String name;
	private LocalTime time;
	String lastOutput;

	public Ohce(String name) {
		this.time = LocalTime.now();
		this.name = name;

		greeting();
	}

	public String lastOutput() {

		return lastOutput;
	}

	public void greeting() {

		LocalTime lt12 = LocalTime.of(12, 0);
		LocalTime lt20 = LocalTime.of(20, 0);

		if (time.isBefore(lt12)) {
			lastOutput = "¡Buenos días " + name + "!";
		} else {

			if (time.isBefore(lt20)) {
				lastOutput = "¡Buenas tardes " + name + "!";
			} else {
				lastOutput = "¡Buenas noches " + name + "!";
			}
		}
	}

	public void enter(String inputString) {
		StringBuilder input = new StringBuilder(inputString);

		lastOutput = input.reverse().toString();

	}

}
