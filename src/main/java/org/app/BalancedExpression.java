package org.app;

public class BalancedExpression {
    public boolean check(String expression) {
        if(expression == null || expression.isEmpty() || expression.isBlank()) {
            return false;
        }

        String beginOfGroupingSigns = buildBeginGroupingSigns(expression);
        String endOfGroupSigns = buildEndGroupingSigns(expression);

        if(beginOfGroupingSigns.length() != endOfGroupSigns.length()) {
            return false;
        }

        for(int i = 0; i < beginOfGroupingSigns.length(); i++) {
            if(beginOfGroupingSigns.charAt(i) == '(' && endOfGroupSigns.charAt(i) != ')') {
                return false;
            }
            if(beginOfGroupingSigns.charAt(i) == '[' && endOfGroupSigns.charAt(i) != ']') {
                return false;
            }
            if(beginOfGroupingSigns.charAt(i) == '{' && endOfGroupSigns.charAt(i) != '}') {
                return false;
            }
        }
        return true;
    }

    private String buildBeginGroupingSigns(String expression) {
        StringBuilder beginOfGroupingSigns = buildGroupingSigns(expression, "([{");
        return beginOfGroupingSigns.toString();
    }

    private String buildEndGroupingSigns(String expression) {
        StringBuilder endOfGroupingSigns = buildGroupingSigns(expression, ")]}");
        return endOfGroupingSigns.reverse().toString();
    }

    private StringBuilder buildGroupingSigns(String expression, String baseGroupOfSigns) {
        StringBuilder expressionGroupingSigns = new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == baseGroupOfSigns.charAt(0)
                    || expression.charAt(i) == baseGroupOfSigns.charAt(1)
                    || expression.charAt(i) == baseGroupOfSigns.charAt(2) ) {
                expressionGroupingSigns.append(expression.charAt(i));
            }
        }
        return expressionGroupingSigns;
    }
}
