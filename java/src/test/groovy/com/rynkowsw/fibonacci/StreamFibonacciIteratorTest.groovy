package com.rynkowsw.fibonacci

import java.util.stream.Stream

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class StreamFibonacciIteratorTest extends Specification {


    private int ANY_NUMBER = 22

    def 'fibonacci number is valid'() {
        given:
            StreamFibonacci fibonacciCreator = new StreamFibonacci()
            Stream<BigInteger>  streamFibonacci = fibonacciCreator.getFibonnaciStream()
        when:
            Optional<BigInteger> testStream = streamFibonacci.skip(ANY_NUMBER).findFirst()
        then:
            Fibonacci.fibonacci(ANY_NUMBER) == testStream.get()
    }
}
