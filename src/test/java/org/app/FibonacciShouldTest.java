package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class FibonacciShouldTest {
    private Fibonacci fibonacci;
    private Exception returnedException;
    private String returnedResult;


    @Test
    void returnFirstTenNumbers() {
        giveMeFibonacci();
        giveMeReturnedException();
        whenGenerateFirstTenNumber();
        thenFirstTenNumberAreReturned();
    }

    @Test
    void returnFirstFiftyNumbers() {
        giveMeFibonacci();
        giveMeReturnedException();
        whenGenerateFirstFiftyNumber();
        thenFirstFiftyNumberAreReturned();
    }

    @Test
    void returnEmptyStringIfLimitIsZero() {
        giveMeFibonacci();
        giveMeReturnedException();
        whenGenerateFirstZeroNumber();
        thenFirstZeroNumberAreReturned();
    }

    @Test
    void returnEmptyStringIfLimitIsLessThanZero() {
        giveMeFibonacci();
        giveMeReturnedException();
        whenGenerateFirstIsLessThanZeroNumber();
        thenFirstIsLessThanZeroNumberAreReturned();
    }

    private void whenGenerateFirstIsLessThanZeroNumber() {
        try {
            returnedResult = fibonacci.generate(-1);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenFirstIsLessThanZeroNumberAreReturned() {
        verify(fibonacci, only()).generate(-1);
        verifyNoMoreInteractions(fibonacci);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void whenGenerateFirstZeroNumber() {
        try {
            returnedResult = fibonacci.generate(0);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenFirstZeroNumberAreReturned() {
        verify(fibonacci, only()).generate(0);
        verifyNoMoreInteractions(fibonacci);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void whenGenerateFirstFiftyNumber() {
        try {
            returnedResult = fibonacci.generate(50);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenFirstFiftyNumberAreReturned() {
        verify(fibonacci, only()).generate(50);
        verifyNoMoreInteractions(fibonacci);
        assertNull(returnedException);
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, " +
                "6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, " +
                "3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, " +
                "433494437, 701408733, 1134903170, 1836311903, 2971215073, 4807526976, 7778742049",returnedResult);
    }

    private void whenGenerateFirstTenNumber() {
        try {
            returnedResult = fibonacci.generate(10);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenFirstTenNumberAreReturned() {
        verify(fibonacci, only()).generate(10);
        verifyNoMoreInteractions(fibonacci);
        assertNull(returnedException);
        assertEquals("0, 1, 1, 2, 3, 5, 8, 13, 21, 34",returnedResult);
    }

    private void giveMeFibonacci() {
        fibonacci = spy(new Fibonacci());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }

}
