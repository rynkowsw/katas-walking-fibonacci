package com.rynkowsw.fibonacci;

import java.math.BigInteger;
import java.util.Iterator;

import static com.rynkowsw.fibonacci.Fibonacci.calculateNextFibonacci;

/**
 * Created by wojciech on 24.05.17.
 */
public class FibonacciIterator implements Iterator<BigInteger> {

    private FibonacciPair iteratorState;

    public BigInteger next(){

        if(iteratorState == null || iteratorState.getN_1IteratorValue() == null) {
            iteratorState = new FibonacciPair(BigInteger.ZERO, null);
            return BigInteger.ZERO;
        } else if(iteratorState.getNIteratorValue() == null){
            iteratorState = new FibonacciPair(BigInteger.ZERO, BigInteger.ONE);
            return BigInteger.ONE;
        }

        iteratorState = calculateNextFibonacci(iteratorState);

        return iteratorState.getCurrentFibonacciNumber();
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
