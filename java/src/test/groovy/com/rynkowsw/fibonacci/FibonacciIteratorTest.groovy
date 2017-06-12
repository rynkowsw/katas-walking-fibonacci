package com.rynkowsw.fibonacci

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class FibonacciIteratorTest extends Specification {

    private final ANY_NUMBER = 1010

    def 'fibonacci iterator first value is zero' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
        when: 'getting first element'
            BigInteger iteratorFibonacciNumber = iterator.next()
        then:
            iteratorFibonacciNumber == BigInteger.ZERO
    }

    def 'fibonacci iterator second value is one' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
        when: 'getting second element'
            BigInteger iteratorFibonacciNumber = ++iterator.next()
        then:
            iteratorFibonacciNumber == BigInteger.ONE
    }

    def 'n fibonacci iterator value is equal to sum of n-1 and n-2 values' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
            BigInteger nMinus2, nMinus1, n
            skipNValues(iterator, ANY_NUMBER )
        when:
            nMinus2 = iterator.next()
            nMinus1 = iterator.next()
            n = iterator.next()
        then:
            n == nMinus2.add(nMinus1)
    }


    private static void skipNValues(Iterator iterator, int numberOfSkippedValues)
    {
        for (int i = 0; i < numberOfSkippedValues ; i++) {
            iterator.next()
        }
    }
}
