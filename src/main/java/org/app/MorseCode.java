package org.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MorseCode {
    private Map<String, String> morseDictionary;
    private Map<String, String> naturalDictionary;

    public MorseCode() {
        setMorseDictionary();
        setNaturalDictionary();
    }

    public String translate(String text) {
        if(text == null || text.isBlank() || text.isEmpty()) {
            return "";
        }
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(text);
        return matcher.find() ? translateToMorseCode(text) : translateNaturalLanguage(text);
    }

    private String translateToMorseCode(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        text = text.toUpperCase();
        for(int i = 0; i < text.length(); i++){
            String letter = String.valueOf(text.charAt(i));
            String translateLetter = naturalDictionary.get(letter);
            stringBuilder.append(Objects.requireNonNullElse(translateLetter, letter)).append(" ");
        }
        return stringBuilder.toString();
    }

    private String translateNaturalLanguage(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        text = text.replace("   ", "  ");
        String[] splitText = text.split(" ");
        for (String symbol : splitText) {
            if(symbol.equals("")) {
                stringBuilder.append(" ");
            } else {
                String translateLetter = morseDictionary.get(symbol);
                stringBuilder.append(Objects.requireNonNullElse(translateLetter, symbol));
            }
        }
        return stringBuilder.toString();
    }

    private void setMorseDictionary() {
        morseDictionary = new HashMap<>();
        morseDictionary.put(".-","A");
        morseDictionary.put("-...","B");
        morseDictionary.put("-.-.","C");
        morseDictionary.put("-..","D");
        morseDictionary.put(".","E");
        morseDictionary.put("..-.","F");
        morseDictionary.put("--.","G");
        morseDictionary.put("....","H");
        morseDictionary.put("..","I");
        morseDictionary.put(".---","J");
        morseDictionary.put("-.-","K");
        morseDictionary.put(".-..","L");
        morseDictionary.put("--","M");
        morseDictionary.put("-.","N");
        morseDictionary.put("---","O");
        morseDictionary.put(".--.","P");
        morseDictionary.put("--.-","Q");
        morseDictionary.put(".-.","R");
        morseDictionary.put("...","S");
        morseDictionary.put("-","T");
        morseDictionary.put("..-","U");
        morseDictionary.put("...-","V");
        morseDictionary.put(".--","W");
        morseDictionary.put("-..-","X");
        morseDictionary.put("-.--","Y");
        morseDictionary.put("--..","Z");
        morseDictionary.put(".----","1");
        morseDictionary.put("..---","2");
        morseDictionary.put("...--","3");
        morseDictionary.put("....-","4");
        morseDictionary.put(".....","5");
        morseDictionary.put("-....","6");
        morseDictionary.put("--...","7");
        morseDictionary.put("---..","8");
        morseDictionary.put("----.","9");
        morseDictionary.put("-----","0");
    }

    private void setNaturalDictionary() {
        naturalDictionary = new HashMap<>();
        naturalDictionary.put("A", ".-");
        naturalDictionary.put("B", "-...");
        naturalDictionary.put("C", "-.-.");
        naturalDictionary.put("D", "-..");
        naturalDictionary.put("E", ".");
        naturalDictionary.put("F", "..-.");
        naturalDictionary.put("G", "--.");
        naturalDictionary.put("H", "....");
        naturalDictionary.put("I", "..");
        naturalDictionary.put("J", ".---");
        naturalDictionary.put("K", "-.-");
        naturalDictionary.put("L", ".-..");
        naturalDictionary.put("M", "--");
        naturalDictionary.put("N", "-.");
        naturalDictionary.put("O", "---");
        naturalDictionary.put("P", ".--.");
        naturalDictionary.put("Q", "--.-");
        naturalDictionary.put("R", ".-.");
        naturalDictionary.put("S", "...");
        naturalDictionary.put("T", "-");
        naturalDictionary.put("U", "..-");
        naturalDictionary.put("V", "...-");
        naturalDictionary.put("W", ".--");
        naturalDictionary.put("X", "-..-");
        naturalDictionary.put("Y", "-.--");
        naturalDictionary.put("Z", "--..");
        naturalDictionary.put("1", ".----");
        naturalDictionary.put("2", "..---");
        naturalDictionary.put("3", "...--");
        naturalDictionary.put("4", "....-");
        naturalDictionary.put("5", ".....");
        naturalDictionary.put("6", "-....");
        naturalDictionary.put("7", "--...");
        naturalDictionary.put("8", "---..");
        naturalDictionary.put("9", "----.");
        naturalDictionary.put("0", "-----");
    }

}
