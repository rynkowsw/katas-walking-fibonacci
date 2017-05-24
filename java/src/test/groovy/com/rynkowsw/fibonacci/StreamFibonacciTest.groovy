package com.rynkowsw.fibonacci

import java.util.stream.Stream

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class StreamFibonacciTest extends Specification {


    private String THREE_HUNDRED_ONE_FIBONACCI_VALUE = '222232244629420445529739893461909967206666939096499764990979600'

    def ' creates valid stream of fiboncci values'() {
        given:
            StreamFibonacci fibonacciCreator = new StreamFibonacci()
            Stream<BigInteger>  streamFibonacci = fibonacciCreator.getFibonnaciStream()
        when:
            Stream<BigInteger> testStream = streamFibonacci.limit(10)
        then:
            [0, 1, 1, 2, 3, 5, 8, 13, 21, 34] == testStream.toArray()
    }


    def '301 fibonacci number is valid'() {
        given:
            StreamFibonacci fibonacciCreator = new StreamFibonacci()
            Stream<BigInteger>  streamFibonacci = fibonacciCreator.getFibonnaciStream()
        when:
            Optional<BigInteger> testStream = streamFibonacci.skip(300).findFirst()
        then:
            new BigInteger(THREE_HUNDRED_ONE_FIBONACCI_VALUE) == testStream.get()
    }
}
