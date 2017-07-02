package com.rynkowsw.fibonacci;

import java.math.BigInteger;

/**
 * Class created for better testing  possibility
 */
class FibonacciNumberCalculator {

    protected BigInteger addTwoNumber(BigInteger number1, BigInteger number2 ){

        BigInteger nextFibonacciValue = BigInteger.ZERO
                .add(number1)
                .add(number2);

        return nextFibonacciValue;
    }
}