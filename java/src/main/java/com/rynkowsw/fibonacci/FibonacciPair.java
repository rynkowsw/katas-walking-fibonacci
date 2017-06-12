package com.rynkowsw.fibonacci;

import java.math.BigInteger;

/**
 * Created by wojciech on 11.06.17.
 */
public class FibonacciPair {

    private final BigInteger n_1IteratorValue, nIteratorValue;

    public FibonacciPair(BigInteger n_1IteratorValue, BigInteger nIteratorValue) {
        this.n_1IteratorValue = n_1IteratorValue;
        this.nIteratorValue = nIteratorValue;
    }

    public BigInteger getN_1IteratorValue() {
        return n_1IteratorValue;
    }

    public BigInteger getNIteratorValue() {
        return nIteratorValue;
    }

    public BigInteger getCurrentFibonacciNumber(){
        return new BigInteger(nIteratorValue.toString());
    }
}
