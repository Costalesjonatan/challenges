package org.app;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Fibonacci {

    public String generate(int limit) {

        if(limit <= 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        long previousToPrevious = 0;
        long previous = 1;

        result.append(0).append(", ").append(1).append(", ");

        for(int i = 2; i < limit; i++) {
            long actual = previousToPrevious + previous;
            result.append(actual);
            previousToPrevious = previous;
            previous = actual;
            if(i+1 != limit) {
                result.append(", ");
            }
        }

        return result.toString();
    }

}
