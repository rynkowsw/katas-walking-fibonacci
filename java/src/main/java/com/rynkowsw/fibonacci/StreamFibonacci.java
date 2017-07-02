package com.rynkowsw.fibonacci;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by wojciech on 24.05.17.
 */
public class StreamFibonacci {

    private Iterator<BigInteger> fibonacciIterator;

    public StreamFibonacci( Iterator fibonacciIterator){
        this.fibonacciIterator = fibonacciIterator;
    }

    public StreamFibonacci(){
        fibonacciIterator = new FibonacciIterator();
    }
    
    public Stream<BigInteger> getFibonnaciStream(){
        return asStream(fibonacciIterator);
    }


    private static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        return asStream(sourceIterator, false);
    }

    private static <T> Stream<T> asStream(Iterator<T> sourceIterator, boolean parallel) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }

}
