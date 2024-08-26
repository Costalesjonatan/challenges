package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class DecimalToBinaryShouldTest {
    private DecimalToBinary decimalToBinary;
    private String returnedResult;
    private Exception returnedException;

    @Test
    void convertDecimalToBinaryCorrectly() {
        giveMeDecimalToBinary();
        giveMeReturnedException();
        whenExecute();
        thenConvertCorrectly();
    }

    @Test
    void returnEmptyString() {
        giveMeDecimalToBinary();
        giveMeReturnedException();
        whenExecuteWithDecimalLessThanZero();
        thenEmptyStringIsReturned();
    }

    @Test
    void returnZero() {
        giveMeDecimalToBinary();
        giveMeReturnedException();
        whenExecuteWithDecimalEqualToZero();
        thenZeroStringIsReturned();
    }

    @Test
    void convertLongDecimalToBinaryCorrectly() {
        giveMeDecimalToBinary();
        giveMeReturnedException();
        whenExecuteWithLongDecimal();
        thenConvertCorrectlyLongDecimal();
    }

    private void whenExecuteWithLongDecimal() {
        try {
            returnedResult = decimalToBinary.execute(2147483647);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenConvertCorrectlyLongDecimal() {
        verify(decimalToBinary, only()).execute(2147483647);
        verifyNoMoreInteractions(decimalToBinary);
        assertNull(returnedException);
        assertEquals("1111111111111111111111111111111",returnedResult);
    }

    private void whenExecuteWithDecimalEqualToZero() {
        try {
            returnedResult = decimalToBinary.execute(0);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenZeroStringIsReturned() {
        verify(decimalToBinary, only()).execute(0);
        verifyNoMoreInteractions(decimalToBinary);
        assertNull(returnedException);
        assertEquals("0",returnedResult);
    }

    private void whenExecuteWithDecimalLessThanZero() {
        try {
            returnedResult = decimalToBinary.execute(-1);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenEmptyStringIsReturned() {
        verify(decimalToBinary, only()).execute(-1);
        verifyNoMoreInteractions(decimalToBinary);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void whenExecute() {
        try {
            returnedResult = decimalToBinary.execute(10);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenConvertCorrectly() {
        verify(decimalToBinary, only()).execute(10);
        verifyNoMoreInteractions(decimalToBinary);
        assertNull(returnedException);
        assertEquals("1010",returnedResult);
    }

    private void giveMeDecimalToBinary() {
        decimalToBinary = spy(new DecimalToBinary());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }
}
