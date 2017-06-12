package com.rynkowsw.fibonacci;

import java.math.BigInteger;

/**
 * Created by wojciech on 11.06.17.
 */
public class Fibonacci {

    public static String FIBONACCI_PAIR_INVALID_ARGUMENT = "Fibonacci pair contains null arguments";

    public static String FIBONACCI_FOR_NEGATIVE_NUMBER_EXCEPTION = "Fibonacci can not be calculated for negative number";

    public static FibonacciPair calculateNextFibonacci(FibonacciPair fibonacciState)
    {
        BigInteger n_1IteratorValue = fibonacciState.getN_1IteratorValue(),
                nIteratorValue = fibonacciState.getNIteratorValue();

        if( nIteratorValue == null || n_1IteratorValue == null)
            throw new RuntimeException(FIBONACCI_PAIR_INVALID_ARGUMENT);

        return new FibonacciPair(
                nIteratorValue,
                nIteratorValue.add(n_1IteratorValue)
        );
    }


    public static BigInteger fibonacci(int number)
    {
        if ( number < 0 ) {
            throw new RuntimeException(FIBONACCI_FOR_NEGATIVE_NUMBER_EXCEPTION);
        } else if ( number == 0 ) {
            return BigInteger.ZERO;
        }
        else if ( number == 1 ){
            return BigInteger.ONE;
        }

        FibonacciPair fibonacciPair = new FibonacciPair( BigInteger.ZERO, BigInteger.ONE) ;

        for (int i = 1; i < number ; i++) {
            fibonacciPair = calculateNextFibonacci(fibonacciPair);
        }

        return fibonacciPair.getNIteratorValue();
    }




}
