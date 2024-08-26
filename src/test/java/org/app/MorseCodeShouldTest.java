package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class MorseCodeShouldTest {
    private MorseCode morseCode;
    private String returnedResult;
    private Exception returnedException;

    @Test
    void translateToMorseCodeCorrectly() {
        giveMeMorseCode();
        giveMeReturnedException();
        whenTranslateToMorseCode();
        thenTheTranslationIsCorrect();
    }

    @Test
    void translateToNaturalLanguageCorrectly() {
        giveMeMorseCode();
        giveMeReturnedException();
        whenTranslateToNaturalLanguage();
        thenTheTranslationToNaturalLanguageIsCorrect();
    }

    @Test
    void returnEmptyIfTextIsNull() {
        giveMeMorseCode();
        giveMeReturnedException();
        whenTranslateWithInvalidText(null);
        thenEmptyStringIsReturned(null);
    }

    @Test
    void returnEmptyIfTextIsEmpty() {
        giveMeMorseCode();
        giveMeReturnedException();
        whenTranslateWithInvalidText("");
        thenEmptyStringIsReturned("");
    }

    @Test
    void returnEmptyIfTextIsBlank() {
        giveMeMorseCode();
        giveMeReturnedException();
        whenTranslateWithInvalidText("   ");
        thenEmptyStringIsReturned("   ");
    }

    private void whenTranslateToNaturalLanguage() {
        try {
            returnedResult = morseCode.translate(".... . .-.. .-.. ---   .-- --- .-. .-.. -..");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenTheTranslationToNaturalLanguageIsCorrect() {
        verify(morseCode, only()).translate(".... . .-.. .-.. ---   .-- --- .-. .-.. -..");
        verifyNoMoreInteractions(morseCode);
        assertNull(returnedException);
        assertEquals("HELLO WORLD",returnedResult);
    }

    private void whenTranslateWithInvalidText(String text) {
        try {
            returnedResult = morseCode.translate(text);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenEmptyStringIsReturned(String text) {
        verify(morseCode, only()).translate(text);
        verifyNoMoreInteractions(morseCode);
        assertNull(returnedException);
        assertEquals("",returnedResult);
    }

    private void whenTranslateToMorseCode() {
        try {
            returnedResult = morseCode.translate("Hello world!");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenTheTranslationIsCorrect() {
        verify(morseCode, only()).translate("Hello world!");
        verifyNoMoreInteractions(morseCode);
        assertNull(returnedException);
        assertEquals(".... . .-.. .-.. ---   .-- --- .-. .-.. -.. ! ",returnedResult);
    }

    private void giveMeMorseCode() {
        morseCode = spy(new MorseCode());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }
}
