package org.app;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PrimeNumbers {

    public String generate(long limit) {

        if(limit <= 0){
            return "";
        }

        StringBuilder result = new StringBuilder();

        for(long i = 2; i <= limit; i++) {
            if(isPrime(i)) {
                result.append(i).append(" ");
            }
        }
        return result.toString();
    }

    private boolean isPrime(long number) {
        for(long i = 2; i < number; i++) {
            if(number%i == 0) {
                return false;
            }
        }
        return true;
    }

}
