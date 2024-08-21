package org.app;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class IsAnAnagram {
    public boolean execute(String firstWord, String secondWord) {

        if(firstWord.equals(secondWord)) {
            return false;
        }
        if(firstWord.length() != secondWord.length()) {
            return false;
        }

        for(int i = 0; i < firstWord.length(); i++) {
            if(!secondWord.contains(String.valueOf(firstWord.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}
