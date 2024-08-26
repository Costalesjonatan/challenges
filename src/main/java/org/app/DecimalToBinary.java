package org.app;

public class DecimalToBinary {
    public String execute(int decimal) {

        if (decimal < 0) {
            return "";
        }
        if (decimal == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        while(decimal > 0) {
            result.append(decimal%2);
            decimal/=2;
        }
        return  result.reverse().toString();
    }
}
