package org.app;

import lombok.NoArgsConstructor;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.Map;

@Log
@NoArgsConstructor
public class CountWords {
    public Map<String, Integer> execute(String sentence) {
        if(sentence == null || sentence.isEmpty() || sentence.isBlank()) {
            throw new IllegalArgumentException("The string should not be null or empty or blank.");
        }
        Map<String, Integer> result = new HashMap<>();
        sentence = sentence.replaceAll("\\p{Punct}","");
        sentence = sentence.replaceAll("[?!¡¿]","");
        sentence = sentence.toLowerCase();
        String[] words = sentence.split(" ");
        for (String word: words) {
            if(result.containsKey(word)) {
                result.put(word, result.get(word) + 1);
            } else {
                result.put(word, 1);
            }
        }
        return result;
    }
}
