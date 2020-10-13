package com.mathAdditional;

import com.mathAdditional.Exceptions.ValueExceedsRamException;

import java.math.BigInteger;

/**
 *  The class {@code Factorial} consists of creating a factorial
 *  number, and properties of them
 *
 * @author Eduardo Ribeiro Leal
 * @version 1.0.0
 * @see com.mathAdditional
 */
public class Factorial {

    private final BigInteger factorial;
    private final int val;

    /**
     *
     * @param val receives the value calculates its factorial and makes its properties available
     * @throws StackOverflowError if the value is too large to calculate the factorial
     */
    public Factorial(int val) throws ValueExceedsRamException {
        this.val = val;
        factorial = getFactorial(new BigInteger(Integer.toString(val)));
    }

    /**
     *
     * @return returns the number of digits of the factorial
     */
    public int getNDigitsOfFactorial(){
        return factorial.bitLength();
    }

    /**
     *
     * @return returns the calculated factorial
     */
    public BigInteger getFactorial(){
        return factorial;
    }

    /**
     *
     * @return returns the number of zeros at the end of the factorial
     */
    public long getNZerosInTheEnd(){
        long result = 0;

        for(int i = 2; i <= val; i++)
            result += countFactorsOf5(i);

        return result;
    }

    @Override
    public String toString() {
        return factorial.toString();
    }

    // Private methods
    private BigInteger getFactorial(BigInteger n) throws ValueExceedsRamException {
        BigInteger result;

        try {
            if (n.equals(BigInteger.ZERO))
                result = BigInteger.ONE;
            else
                result = n.multiply(getFactorial(n.subtract(BigInteger.ONE)));
        } catch (StackOverflowError e){
            throw new ValueExceedsRamException();
        }


        return result;
    }

    private int countFactorsOf5(int i){
        int count = 0;

        while(i % 5 == 0) {
            count++;
            i /= 5;
        }

        return count;
    }
}
