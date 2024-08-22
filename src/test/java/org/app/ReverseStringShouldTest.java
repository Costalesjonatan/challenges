package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class ReverseStringShouldTest {
    private ReverseString reverseString;
    private Exception exceptionThrown;
    private String resultReturned;

    @Test
    void throwExceptionIfStringIsNull() {
        giveMeReverseString();
        giveMeExceptionThrown();
        whenExecuteWithNullString();
        thenExceptionIsThrown();
    }

    @Test
    void reverseString() {
        giveMeReverseString();
        giveMeExceptionThrown();
        whenReverseString();
        thenStringIsInverted();
    }

    private void whenReverseString() {
        try {
            resultReturned = reverseString.execute("reverse string");
        } catch (Exception exception) {
            exceptionThrown = exception;
        }
    }

    private void thenStringIsInverted() {
        verify(reverseString, only()).execute("reverse string");
        verifyNoMoreInteractions(reverseString);
        assertEquals("gnirts esrever", resultReturned);
        assertNull(exceptionThrown);
    }

    private void whenExecuteWithNullString() {
        try {
            resultReturned = reverseString.execute(null);
        } catch (Exception exception) {
            exceptionThrown = exception;
        }
    }

    private void thenExceptionIsThrown() {
        verify(reverseString, only()).execute(null);
        verifyNoMoreInteractions(reverseString);
        assertNull(resultReturned);
        assertNotNull(exceptionThrown);
    }

    private void giveMeReverseString() {
        reverseString = spy(new ReverseString());
    }

    private void giveMeExceptionThrown() {
        exceptionThrown = null;
    }

}
