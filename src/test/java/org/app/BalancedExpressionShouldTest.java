package org.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

class BalancedExpressionShouldTest {
    private BalancedExpression balancedExpression;
    private boolean returnedResult;
    private Exception returnedException;

    @Test
    void returnTrueBecauseTheExpressionIsBalanced() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckBalancedExpression();
        thenReturnTrue();
    }

    @Test
    void returnFalseDifferentLengthCase() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckDifferentLengthCase();
        thenReturnFalse("(a * ( c + d ) ] - 5 }");
    }

    @Test
    void returnFalseParenthesisCase() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckParenthesisCase();
        thenReturnFalse("(a [* ( c + d ) ] - 5 }");
    }

    @Test
    void returnAnotherFalseSquareBracketCase() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckSquareBracketCase();
        thenReturnFalse("([a * ( c + d ) } - 5 )");
    }

    @Test
    void returnFalseKeyBracketCase() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckKeyBracketCase();
        thenReturnFalse("([a * { c + d ) ] - 5 )");
    }

    @Test
    void returnTrueBecauseTheAnotherExpressionIsBalanced() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenCheckAnotherBalancedExpression();
        thenReturnAnotherTrue();
    }

    @Test
    void returnEmptyIfExpressionIsNull() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenTranslateWithInvalidText(null);
        thenEmptyStringIsReturned(null);
    }

    @Test
    void returnEmptyIfExpressionIsEmpty() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenTranslateWithInvalidText("");
        thenEmptyStringIsReturned("");
    }

    @Test
    void returnEmptyIfExpressionIsBlank() {
        giveMeBalancedExpression();
        giveMeReturnedException();
        whenTranslateWithInvalidText("   ");
        thenEmptyStringIsReturned("   ");
    }

    private void whenTranslateWithInvalidText(String expression) {
        try {
            returnedResult = balancedExpression.check(expression);
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenEmptyStringIsReturned(String expression) {
        verify(balancedExpression, only()).check(expression);
        verifyNoMoreInteractions(balancedExpression);
        assertNull(returnedException);
        assertFalse(returnedResult);
    }

    private void whenCheckAnotherBalancedExpression() {
        try {
            returnedResult = balancedExpression.check("{{[[(([{({[()]})}]))]]}}");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenReturnAnotherTrue() {
        verify(balancedExpression, only()).check("{{[[(([{({[()]})}]))]]}}");
        verifyNoMoreInteractions(balancedExpression);
        assertTrue(returnedResult);
        assertNull(returnedException);
    }

    private void whenCheckDifferentLengthCase() {
        try {
            returnedResult = balancedExpression.check("(a * ( c + d ) ] - 5 }");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenCheckKeyBracketCase() {
        try {
            returnedResult = balancedExpression.check("([a * { c + d ) ] - 5 )");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenCheckSquareBracketCase() {
        try {
            returnedResult = balancedExpression.check("([a * ( c + d ) } - 5 )");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void whenCheckParenthesisCase() {
        try {
            returnedResult = balancedExpression.check("(a [* ( c + d ) ] - 5 }");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenReturnFalse(String expression) {
        verify(balancedExpression, only()).check(expression);
        verifyNoMoreInteractions(balancedExpression);
        assertFalse(returnedResult);
        assertNull(returnedException);
    }

    private void whenCheckBalancedExpression() {
        try {
            returnedResult = balancedExpression.check("{ [ a * ( c + d ) ] - 5 }");
        } catch (Exception exception) {
            returnedException = exception;
        }
    }

    private void thenReturnTrue() {
        verify(balancedExpression, only()).check("{ [ a * ( c + d ) ] - 5 }");
        verifyNoMoreInteractions(balancedExpression);
        assertTrue(returnedResult);
        assertNull(returnedException);
    }

    private void giveMeBalancedExpression() {
        balancedExpression = spy(new BalancedExpression());
    }
    private void giveMeReturnedException() {
        returnedException = null;
    }
}
