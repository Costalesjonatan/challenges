package org.app;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReverseString {
    public String execute(String string) {
        if(string == null) {
            throw new IllegalArgumentException("The string should not be null.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = string.length()-1; i >= 0; i--) {
            stringBuilder.append(string.charAt(i));
        }
        return stringBuilder.toString();
    }
}
