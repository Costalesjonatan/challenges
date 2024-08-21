package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class PrimeNumbersShouldTest {
    private PrimeNumbers primeNumbers;
    private Exception returnedException;
    private String returnedResult;


    @Test
    void returnPrimeNumbersBetween1and10AreReturned() {
        giveMePrimeNumbers();
        giveMeReturnedException();
        whenGeneratePrimeNumbersBetween1and10();
        thenPrimeNumbersBetween1and10AreReturned();
    }

    @Test
    void returnPrimeNumbersBetween1and100AreReturned() {
        giveMePrimeNumbers();
        giveMeReturnedException();
        whenGeneratePrimeNumbersBetween1and100();
        thenPrimeNumbersBetween1and100AreReturned();
    }

    @Test
    void returnEmptyStringIfLimitIsZero() {
        giveMePrimeNumbers();
        giveMeReturnedException();
        whenGenerateFirstZeroNumber();
        thenZeroEmptyAreReturned();
    }

    @Test
    void returnEmptyStringIfLimitIsLessThanZero() {
        giveMePrimeNumbers();
        giveMeReturnedException();
        whenLimitIsLessThanZeroNumber();
        thenLessThanZeroEmptyAreReturned();
    }

    private void whenGenerateFirstZeroNumber() {
        try {
            returnedResult = primeNumbers.generate(0);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenLimitIsLessThanZeroNumber() {
        try {
            returnedResult = primeNumbers.generate(-1);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenZeroEmptyAreReturned() {
        verify(primeNumbers, only()).generate(0);
        verifyNoMoreInteractions(primeNumbers);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void thenLessThanZeroEmptyAreReturned() {
        verify(primeNumbers, only()).generate(-1);
        verifyNoMoreInteractions(primeNumbers);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void whenGeneratePrimeNumbersBetween1and100() {
        try {
            returnedResult = primeNumbers.generate(100);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenPrimeNumbersBetween1and100AreReturned() {
        verify(primeNumbers, only()).generate(100);
        verifyNoMoreInteractions(primeNumbers);
        assertNull(returnedException);
        assertEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97 ",returnedResult);
    }

    private void whenGeneratePrimeNumbersBetween1and10() {
        try {
            returnedResult = primeNumbers.generate(10);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenPrimeNumbersBetween1and10AreReturned() {
        verify(primeNumbers, only()).generate(10);
        verifyNoMoreInteractions(primeNumbers);
        assertNull(returnedException);
        assertEquals("2 3 5 7 ",returnedResult);
    }

    private void giveMePrimeNumbers() {
        primeNumbers = spy(new PrimeNumbers());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }
}
