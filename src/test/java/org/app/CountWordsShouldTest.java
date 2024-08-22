package org.app;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class CountWordsShouldTest {
    private CountWords countWords;
    private Exception thrownException;
    private Map<String, Integer> returnedResult;
    private Map<String, Integer> expectedResult;

    @Test
    void countWords() {
        giveMeExceptionThrown();
        giveMeCountWords();
        whenCountingWords();
        thenWordsAreCounted();
    }

    @Test
    void countWordsAgain() {
        giveMeExceptionThrown();
        giveMeCountWords();
        whenCountingWordsAgain();
        thenWordsAreCountedAgain();
    }

    @Test
    void throwExceptionIfSentenceIsNull() {
        giveMeExceptionThrown();
        giveMeCountWords();
        whenExecuteWithNullSentence();
        thenExceptionIsThrown(null);
    }

    @Test
    void throwExceptionIfSentenceIsEmpty() {
        giveMeExceptionThrown();
        giveMeCountWords();
        whenExecuteWithEmptySentence();
        thenExceptionIsThrown("");
    }

    @Test
    void throwExceptionIfSentenceIsBlank() {
        giveMeExceptionThrown();
        giveMeCountWords();
        whenExecuteWithBlankSentence();
        thenExceptionIsThrown("     ");
    }

    private void whenCountingWordsAgain() {
        expectedResult = new HashMap<>();
        expectedResult.put("new", 2);
        expectedResult.put("phrase", 2);
        expectedResult.put("with", 2);
        expectedResult.put("more", 2);
        expectedResult.put("words", 2);
        expectedResult.put("to", 2);
        expectedResult.put("try", 2);
        try {
            returnedResult = countWords.execute("New phrase, with more words to try.!{}[]!?¿,.!'¡<>!, " +
                    "New phrase, with more words to try");
        } catch (Exception exception) {
            thrownException = exception;
        }
    }

    private void thenWordsAreCountedAgain() {
        verify(countWords, only()).execute("New phrase, with more words to try.!{}[]!?¿,.!'¡<>!, " +
                "New phrase, with more words to try");
        verifyNoMoreInteractions(countWords);
        assertTrue(returnedResult.containsKey("new"));
        assertTrue(returnedResult.containsKey("phrase"));
        assertTrue(returnedResult.containsKey("with"));
        assertTrue(returnedResult.containsKey("more"));
        assertTrue(returnedResult.containsKey("words"));
        assertTrue(returnedResult.containsKey("to"));
        assertTrue(returnedResult.containsKey("try"));
        assertEquals(2, (int) returnedResult.get("new"));
        assertEquals(2, (int) returnedResult.get("phrase"));
        assertEquals(2, (int) returnedResult.get("with"));
        assertEquals(2, (int) returnedResult.get("more"));
        assertEquals(2, (int) returnedResult.get("words"));
        assertEquals(2, (int) returnedResult.get("to"));
        assertEquals(2, (int) returnedResult.get("try"));
        assertNull(thrownException);
    }

    private void whenCountingWords() {
        expectedResult = new HashMap<>();
        expectedResult.put("new", 1);
        expectedResult.put("sentence", 1);
        try {
            returnedResult = countWords.execute("New sentence.");
        } catch (Exception exception) {
            thrownException = exception;
        }
    }

    private void thenWordsAreCounted() {
        verify(countWords, only()).execute("New sentence.");
        verifyNoMoreInteractions(countWords);
        assertTrue(returnedResult.containsKey("new"));
        assertTrue(returnedResult.containsKey("sentence"));
        assertEquals(1, (int) returnedResult.get("new"));
        assertEquals(1, (int) returnedResult.get("sentence"));
        assertNull(thrownException);
    }

    private void whenExecuteWithBlankSentence() {
        try {
            returnedResult = countWords.execute("     ");
        } catch (Exception exception) {
            thrownException = exception;
        }
    }

    private void whenExecuteWithEmptySentence() {
        try {
            returnedResult = countWords.execute("");
        } catch (Exception exception) {
            thrownException = exception;
        }
    }

    private void whenExecuteWithNullSentence() {
        try {
            returnedResult = countWords.execute(null);
        } catch (Exception exception) {
            thrownException = exception;
        }
    }

    private void thenExceptionIsThrown(String sentence) {
        verify(countWords, only()).execute(sentence);
        verifyNoMoreInteractions(countWords);
        assertNull(returnedResult);
        assertNotNull(thrownException);
    }

    private void giveMeCountWords() {
        countWords = spy(new CountWords());
    }

    private void giveMeExceptionThrown() {
        thrownException = null;
    }
}
