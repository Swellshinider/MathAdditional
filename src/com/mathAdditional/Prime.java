package com.mathAdditional;

/**
 *  The class {@code Prime} this class is for static use only, to prime numbers
 *
 * @author Eduardo Ribeiro Leal
 * @version 1.0.0
 * @see com.mathAdditional
 */
public class Prime {

    /**
     * No instances for you
     */
    private Prime(){}

    /**
     *
     * @param value value to check
     * @return return boolean if is prime or not
     */
    public static boolean isPrime(int value){
        if(value <= 1)
            return false;

        if(value == 2)
            return true;

        for(int i = 2; i <= (int) Math.sqrt(value) + 1; i++){
            if(value % i == 0)
                return false;
        }

        return true;
    }

    /**
     *
     * @param value value to check
     * @return return boolean if is prime or not
     */
    public static boolean isPrime(long value){
        if(value <= 1)
            return false;

        if(value == 2)
            return true;

        for(int i = 2; i <= (int) Math.sqrt(value) + 1; i++){
            if(value % i == 0)
                return false;
        }

        return true;
    }

    /**
     *
     * @param value value base
     * @return returns the next prime number excluding the input value
     */
    public static int nextPrimeOf(int value){
        value++;
        while (!isPrime(value)) value++;
        return value;
    }

    /**
     *
     * @param value value base
     * @return returns the previous prime number excluding the input value
     */
    public static int previousPrimeOf(int value){
        value--;
        while (!isPrime(value)) value--;
        return value;
    }

    /**
     *
     * @param value value base
     * @return primeFactorization(12) = 2*2*3
     */
    public static String primeFactorization(long value){
        StringBuilder result = new StringBuilder();

        for(int i = 2; i <= value; i++){
            if(value % i == 0){
                result.append(i).append("*");
                value /= i;
                i--;
            }
        }

        return(result.substring(0, result.length()-1));
    }
}
