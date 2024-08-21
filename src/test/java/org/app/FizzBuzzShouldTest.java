package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class FizzBuzzShouldTest {

    private FizzBuzz fizzBuzz;
    private String returnedResult;
    private Exception returnedException;


    @Test
    void printShortFizzBuzzCorrectly() {
        giveMeFizzBuzz();
        giveMeReturnedException();
        whenMakeShortFizzBuzz();
        thenShortFizzBuzzIsCorrect();
    }

    @Test
    void printLongFizzBuzzCorrectly() {
        giveMeFizzBuzz();
        giveMeReturnedException();
        whenMakeLongFizzBuzz();
        thenLongFizzBuzzIsCorrect();
    }


    private void whenMakeShortFizzBuzz() {
        try {
            returnedResult = fizzBuzz.execute(10);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenShortFizzBuzzIsCorrect() {
        verify(fizzBuzz, only()).execute(10);
        verifyNoMoreInteractions(fizzBuzz);
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz", returnedResult);
        assertNull(returnedException);
    }

    private void whenMakeLongFizzBuzz() {
        try {
            returnedResult = fizzBuzz.execute(50);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenLongFizzBuzzIsCorrect() {
        verify(fizzBuzz, only()).execute(50);
        verifyNoMoreInteractions(fizzBuzz);
        assertEquals("1 2 fizz 4 buzz fizz 7 8 fizz buzz 11 fizz 13 14 " +
                            "fizzbuzz 16 17 fizz 19 buzz fizz 22 23 fizz buzz 26 " +
                            "fizz 28 29 fizzbuzz 31 32 fizz 34 buzz fizz 37 38 fizz " +
                            "buzz 41 fizz 43 44 fizzbuzz 46 47 fizz 49 buzz", returnedResult);
        assertNull(returnedException);
    }

    private void giveMeFizzBuzz() {
        fizzBuzz = spy(new FizzBuzz());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }
}
