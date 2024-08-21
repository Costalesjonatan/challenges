package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class IsAnAnagramShouldTest {
    private IsAnAnagram isAnAnagram;
    private boolean returnedResult;
    private Exception returnedException;

    @Test
    void returnFalseIfWordsAreTheSame() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithEqualsWords();
        thenFalseIsReturned();
    }

    @Test
    void returnFalseIfLengthsAreDifferent() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithDifferentLength();
        thenFalseIsReturned();
    }

    @Test
    void returnFalseIfFirstWordLengthsIsZero() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithFirstWordLengthsIsZero();
        thenFalseIsReturned();
    }

    @Test
    void returnFalseIfSecondWordLengthsIsZero() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithSecondWordLengthsIsZero();
        thenFalseIsReturned();
    }

    @Test
    void returnFalseIfWordsAreNotAnagrams() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithWordsAreNotAnagrams();
        thenFalseIsReturned();
    }

    @Test
    void returnTrue() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithWordsAreAnagrams();
        thenTrueIsReturned();
    }

    @Test
    void returnFalseIfBothWordLengthsIsZero() {
        giveMeIsAnAnagram();
        giveMeReturnedException();
        whenExecuteWithBothWordLengthsIsZero();
        thenFalseIsReturned();
    }

    private void whenExecuteWithBothWordLengthsIsZero() {
        try {
            returnedResult = isAnAnagram.execute("", "");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenExecuteWithWordsAreAnagrams() {
        try {
            returnedResult = isAnAnagram.execute("anagram", "margana");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenTrueIsReturned() {
        verify(isAnAnagram, only()).execute(any(), any());
        verifyNoMoreInteractions(isAnAnagram);
        assertNull(returnedException);
        assertTrue(returnedResult);
    }

    private void whenExecuteWithWordsAreNotAnagrams() {
        try {
            returnedResult = isAnAnagram.execute("test", "zero");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenExecuteWithSecondWordLengthsIsZero() {
        try {
            returnedResult = isAnAnagram.execute("different", "");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenExecuteWithFirstWordLengthsIsZero() {
        try {
            returnedResult = isAnAnagram.execute("", "lengths");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenExecuteWithDifferentLength() {
        try {
            returnedResult = isAnAnagram.execute("different", "lengths");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenExecuteWithEqualsWords() {
        try {
            returnedResult = isAnAnagram.execute("equal words", "equal words");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenFalseIsReturned() {
        verify(isAnAnagram, only()).execute(any(), any());
        verifyNoMoreInteractions(isAnAnagram);
        assertNull(returnedException);
        assertFalse(returnedResult);
    }

    private void giveMeIsAnAnagram() {
        isAnAnagram = spy(new IsAnAnagram());
    }

    private void giveMeReturnedException() {
        returnedException = null;
    }

}
