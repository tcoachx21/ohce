package com.example.ohce;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class OcheTest {

	static LocalTime time6am;
	static LocalTime time12pm;
	static LocalTime time8pm;
	static MockedStatic<LocalTime> staticTime;

	@Mock
	LocalTime localTimeMock;

	@BeforeAll
	static void setUp() throws Exception {
		// setup needed time offsets
		time6am = LocalTime.of(6, 0);
		time12pm = LocalTime.of(12, 0);
		time8pm = LocalTime.of(20, 0);

		// Mock LocalTime
		staticTime = Mockito.mockStatic(LocalTime.class);

		// configure mock behaviour when asked for time offsets
		staticTime.when(() -> LocalTime.of(6, 0)).thenReturn(time6am);
		staticTime.when(() -> LocalTime.of(12, 0)).thenReturn(time12pm);
		staticTime.when(() -> LocalTime.of(20, 0)).thenReturn(time8pm);
	}

	// it's 6pm with the name Marc then output greetings is Buenos Dias Marc!
	@Test
	void startingAt6AMwithMarkShouldOutputBuenosDiasMark() {

		// Mock will be returning now() as 6:00
		staticTime.when(LocalTime::now).thenReturn(time6am);

		Ohce ohce = new Ohce("Mark");
		assertEquals("¡Buenos días Mark!", ohce.lastOutput());
	}

	// it's 6pm with the name Pierre then output will be Buenas Tardes Pierre!
	@Test
	void startingAt6AMwithPierreShouldOutputBuenosDiasPierre() {

		// Mock will be returning now() as 6:00
		staticTime.when(LocalTime::now).thenReturn(time6am);

		Ohce ohce = new Ohce("Pierre");
		assertEquals("¡Buenos días Pierre!", ohce.lastOutput());
	}

	// it's 12pm with the name Marc then output will be Buenas Tardes Marc!
	@Test
	void startingAt12PMwithPierreShouldOutputBuenosDiasPierre() {

		// Mock will be returning now() as 12:00
		staticTime.when(LocalTime::now).thenReturn(time12pm);

		Ohce ohce = new Ohce("Pierre");
		assertEquals("¡Buenas tardes Pierre!", ohce.lastOutput());
	}

	// it's 8pm with Hannah then output will be Buenas Noches Hannah!
	@Test
	void startingAt8PMwithHannahShouldOutputBuenasNochesHannah() {

		// Mock will be returning now() as 20:00
		staticTime.when(LocalTime::now).thenReturn(time8pm);

		Ohce ohce = new Ohce("Hannah");
		assertEquals("¡Buenas noches Hannah!", ohce.lastOutput());
	}

	// when user inputs dog, then output will be god
	@Test
	void afterEnteringDogOutputWillBeGod() {

		// Mock will be returning now() as 20:00
		staticTime.when(LocalTime::now).thenReturn(time8pm);

		Ohce ohce = new Ohce("Hannah");
		ohce.enter("dog");
		assertEquals("god", ohce.lastOutput());
	}

	// using mock we can run our application, connected to the System.out stream:
	@Test
	void runningApplicationWithOhceProducesGreetingsAndReversedOutputs() throws IOException {
		Writer outputWriter = new StringWriter();

		// Mock will be returning now() as 12:00
		staticTime.when(LocalTime::now).thenReturn(time6am);

		OhceApplication app = new OhceApplication(outputWriter, "Hannah");
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
