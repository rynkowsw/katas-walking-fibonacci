package com.rynkowsw.fibonacci

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class FibonacciTest extends Specification {

    def 'fibancci iterator returns valid values' () {
        given:
            Fibonacci fibonacci = new Fibonacci()
        when: 'getting first element'
            BigInteger result = fibonacci.next()
        then:
            result == BigInteger.ZERO
        when: 'getting second element'
            result = fibonacci.next()
        then:
            result.equals(new BigInteger(1))
        when: 'getting third element'
            result = fibonacci.next()
        then:
            result.equals(new BigInteger(1))
        when: 'getting four element'
            result = fibonacci.next()
        then:
            result.equals(new BigInteger(2))
    }
}
