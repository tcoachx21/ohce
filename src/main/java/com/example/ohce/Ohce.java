package com.example.ohce;

import java.time.LocalTime;

public class Ohce {

	private String name;
	private LocalTime time;
	String lastOutput;

	public Ohce(LocalTime time, String name) {
		this.name = name;
		this.time = time;
		greeting();
	}

	public String lastOutput() {

		return lastOutput;
	}

	public void greeting() {
		if (time.isBefore(LocalTime.of(12, 0))) {
			lastOutput = "¡Buenos días " + name + "!";
		} else if (time.isBefore(LocalTime.of(20, 0))) {
			lastOutput = "¡Buenas tardes " + name + "!";
		} else {
			lastOutput = "¡Buenas noches " + name + "!";
		}
	}

	public void enter(String inputString) {
		StringBuilder input = new StringBuilder(inputString);

		lastOutput = input.reverse().toString();

	}

}
