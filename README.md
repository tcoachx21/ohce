**ohce** is a console application that echoes the reverse of what you input through the console.

Even though it seems a silly application, **ohce** knows a thing or two.

1. When you start oche, it greets you differently depending on the current time, but only in Spanish: 
    - Between 20 and 6 hours, **ohce** will greet you saying:  *¡Buenas noches < your name >!*
    - Between 6 and 12 hours, **ohce** will greet you saying:  *¡Buenos días < your name >!*
    - Between 12 and 20 hours, **ohce** will greet you saying:  *¡Buenas tardes < your name >!*
2. When you introduce a palindrome, **ohce** likes it and after reverse-echoing it, it adds *¡Bonita palabra!*
3. **ohce** knows when to stop, you just have to write *Stop!* and it'll answer *Adios < your name >* and end.

This is an example of using **ohce** during the morning:

    $ ohce Pedro
    > ¡Buenos días Pedro!
    $ hola
    > aloh
    $ oto
    > oto
    > ¡Bonita palabra!
    $ stop
    > pots
    $ Stop!
    > Adios Pedro
    
    
***

This repository has 3 branches of code prepared for Training Sessions:


**master:**
	Skeleton Java Project, prepared as a Maven Project with pre-configured 
	dependencies on JUnit and Mockito libraries and a Dummy Test Case.
	You can import it on IDE of your choice and perform the exercise from 
	scratch making use of TDD technique.

**partial_solution:**
	Derived from *master*, with one possible implementation for the 1st requirement performed with TDD technique.
	Time input is exposed to caller, so this solution is easy to implement without advanced mocking strategies.
	
**partial_solution_with_mockito:**
	Also implementing only the first requirement, this version is not exposing the Time variable so tests were 
	implemented with Mokito.
	
 
 
 Based on exercise published on [kata-log](https://kata-log.rocks/ohce-kata).
