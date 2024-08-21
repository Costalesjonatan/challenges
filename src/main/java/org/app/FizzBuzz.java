package org.app;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FizzBuzz {
    public String execute(int limit) {
        StringBuilder result = new StringBuilder();
        boolean divisibleByThree;
        boolean divisibleByFive;

        for(int i = 1; i <= limit; i++) {
            divisibleByThree = i % 3 == 0;
            divisibleByFive = i % 5 == 0;
            if(divisibleByThree && divisibleByFive) {
                result.append("fizzbuzz");
            } else if(divisibleByThree) {
                result.append("fizz");
            }else if(divisibleByFive) {
                result.append("buzz");
            }else{
                result.append(i);
            }
            if(i != limit) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
