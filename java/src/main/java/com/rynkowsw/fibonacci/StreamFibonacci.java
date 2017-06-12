package com.rynkowsw.fibonacci;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by wojciech on 24.05.17.
 */
public class StreamFibonacci {

    private FibonacciIterator fibonacciIterator;

    public StreamFibonacci( FibonacciIterator fibonacciIterator){
        this.fibonacciIterator = fibonacciIterator;
    }

    public StreamFibonacci(){
        fibonacciIterator = new FibonacciIterator();
    }
    
    public Stream<BigInteger> getFibonnaciStream(){
        return StreamUtils.asStream(fibonacciIterator);
    }

}
