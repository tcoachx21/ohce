package com.example.ohce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

class OcheTest {

	// it's 6pm with the name Marc then output greetings is Buenos Dias Marc!
	@Test
	void startingAt6AMwithMarkShouldOutputBuenosDiasMark() {
		Ohce ohce = new Ohce(LocalTime.of(6, 0), "Mark");
		assertEquals("¡Buenos días Mark!", ohce.lastOutput());
	}

	// it's 6pm with the name Pierre then output will be Buenas Tardes Pierre!
	@Test
	void startingAt6AMwithPierreShouldOutputBuenosDiasPierre() {
		Ohce ohce = new Ohce(LocalTime.of(6, 0), "Pierre");
		assertEquals("¡Buenos días Pierre!", ohce.lastOutput());
	}

	// it's 12pm with the name Marc then output will be Buenas Tardes Marc!
	@Test
	void startingAt12PMwithPierreShouldOutputBuenosDiasPierre() {
		Ohce ohce = new Ohce(LocalTime.of(12, 0), "Pierre");
		assertEquals("¡Buenas tardes Pierre!", ohce.lastOutput());
	}

	// it's 8pm with Hannah then output will be Buenas Noches Hannah!
	@Test
	void startingAt8PMwithHannahShouldOutputBuenasNochesHannah() {
		Ohce ohce = new Ohce(LocalTime.of(20, 0), "Hannah");
		assertEquals("¡Buenas noches Hannah!", ohce.lastOutput());
	}

	// when user inputs dog, then output will be god
	@Test
	void afterEnteringDogOutputWillBeGod() {
		Ohce ohce = new Ohce(LocalTime.of(20, 0), "Hannah");
		ohce.enter("dog");
		assertEquals("god", ohce.lastOutput());
	}

	// using mock we can run our application, connected to the System.out stream:
	@Test
	void runningApplicationWithOhceProducesGreetingsAndReversedOutputs() throws IOException {
		Writer outputWriter = new StringWriter();
		OhceApplication app = new OhceApplication(outputWriter, "Hannah", LocalTime.of(6, 0));
		app.run();
		app.enter("hello");
		app.run();
		app.enter("good morning");
		app.run();
		assertEquals("¡Buenos días Hannah!\nolleh\ngninrom doog\n", outputWriter.toString());

	}

	// when time changes, then It Should Return another greeting

	// using mock we can run our application, connected to the System.in stream:
	// StringStream to system in

	// mocking the time
	// Ohce should connect to some timer Object

}
