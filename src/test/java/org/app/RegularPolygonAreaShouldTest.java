package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class RegularPolygonAreaShouldTest {
    private RegularPolygonArea regularPolygonArea;
    private double returnedResult;
    private Exception returnedException;

    @Test
    void returnAreaOfSquareWithSideOneCmLength() {
        giveMePolygonArea();
        giveMeReturnedException();
        whenCalculateAreaOfSquareWithSideOneCmLength();
        thenOneIsReturned();
    }

    @Test
    void returnZeroIfSideQuantityIsZero() {
        giveMePolygonArea();
        giveMeReturnedException();
        whenCalculateAreaWithQuantityZero();
        thenZeroIsReturned(0,1);
    }

    @Test
    void returnZeroIfSideLengthIsZero() {
        giveMePolygonArea();
        giveMeReturnedException();
        whenCalculateAreaWithLengthZero();
        thenZeroIsReturned(1,0);
    }

    private void whenCalculateAreaOfSquareWithSideOneCmLength() {
        try {
            returnedResult = regularPolygonArea.calculate(4,1);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenOneIsReturned() {
        verify(regularPolygonArea, only()).calculate(4,1);
        verifyNoMoreInteractions(regularPolygonArea);
        assertNull(returnedException);
        assertEquals(1,Math.round(returnedResult));
    }

    private void whenCalculateAreaWithLengthZero() {
        try {
            returnedResult = regularPolygonArea.calculate(1,0);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenCalculateAreaWithQuantityZero() {
        try {
            returnedResult = regularPolygonArea.calculate(0,1);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenZeroIsReturned(int sideQuantity, float sideLength) {
        verify(regularPolygonArea, only()).calculate(sideQuantity, sideLength);
        verifyNoMoreInteractions(regularPolygonArea);
        assertNull(returnedException);
        assertEquals(0,returnedResult);
    }

    private void giveMePolygonArea() {
        regularPolygonArea = spy(new RegularPolygonArea());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }
}
