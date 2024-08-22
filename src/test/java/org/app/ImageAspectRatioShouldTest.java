package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class ImageAspectRatioShouldTest {
    private ImageAspectRatio imageAspectRatio;
    private String returnedResult;
    private Exception returnedException;

    @Test
    void calculateAspectRatio() {
        giveMeImageAspectRatio();
        giveMeReturnedException();
        whenCalculateImageAspectRatio();
        thenAspectRatioIsCalculated();
    }

    private void whenCalculateImageAspectRatio() {
        try {
            returnedResult = imageAspectRatio.calculate(1920, 1080);
        } catch (Exception exception) {
            returnedException = null;
        }
    }

    private void thenAspectRatioIsCalculated() {
        verify(imageAspectRatio, only()).calculate(1920, 1080);
        verifyNoMoreInteractions(imageAspectRatio);
        assertNull(returnedException);
        assertEquals("1.77:1",returnedResult);
    }

    private void giveMeImageAspectRatio() {
        imageAspectRatio = spy(new ImageAspectRatio());
    }
    private void giveMeReturnedException() {
        returnedException = null;
    }
}
