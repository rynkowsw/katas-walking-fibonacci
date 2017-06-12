package com.rynkowsw.fibonacci

import spock.lang.Specification


/**
 * Created by wojciech on 11.06.17.
 */
class FibonacciTest extends Specification {

    int NUMBER_N = 100

    int NUMBER_N_MINUS_1 = NUMBER_N -1

    int NUMBER_N_MINUS_2 = NUMBER_N -2


    def 'fibonacci can not be calculated for negative number' () {
        given:
            int NEGATIVE_NUMBER = -3
        when:
            Fibonacci.fibonacci(NEGATIVE_NUMBER)
        then:
            RuntimeException exception = thrown()
            exception.message == Fibonacci.FIBONACCI_FOR_NEGATIVE_NUMBER_EXCEPTION
    }

    def 'fibonacci for 0 is zero - and it is first number of fibonnaci' () {
        when: 'getting 0 element'
            BigInteger result = Fibonacci.fibonacci(0)
        then:
            result == BigInteger.ZERO
    }

    def 'fibonacci for 1 is 1 - and it is second number of fibonnaci' () {
        when: 'getting 1 element'
            BigInteger result = Fibonacci.fibonacci(1)
        then:
            result == BigInteger.ONE
    }

    def 'we can calculate fiboonacci(n) if we have fibonacci(n-1) and fibonacci(n-2)  ' () {
        given:
            BigInteger resultN_MINUS_1 = Fibonacci.fibonacci(NUMBER_N_MINUS_1)
            BigInteger resultN_MINUS_2 = Fibonacci.fibonacci(NUMBER_N_MINUS_2)
            FibonacciPair fibonacciPair = new FibonacciPair(resultN_MINUS_2, resultN_MINUS_1)
        when:
            FibonacciPair result = Fibonacci.calculateNextFibonacci(fibonacciPair)
        then:
            result.getCurrentFibonacciNumber() == Fibonacci.fibonacci(NUMBER_N)
    }

    def 'fibonacci can not be calculated when we have only one of arguments: fibonacci(n-1) or fibonacci(n-2)' () {
        when:
            Fibonacci.calculateNextFibonacci(fibonacciPair)
        then:
            RuntimeException exception = thrown()
            exception.message == Fibonacci.FIBONACCI_PAIR_INVALID_ARGUMENT
        where:
            fibonacciPair << [
                    new FibonacciPair(BigInteger.ZERO, null),
                    new FibonacciPair(null, BigInteger.ZERO)
            ]
    }

    def 'fibonacci for n > 1 is equal fibonacci(n-1) + fibonacci(n-2) ' () {
        when:
            BigInteger resultN = Fibonacci.fibonacci(NUMBER_N)
            BigInteger resultN_MINUS_1 = Fibonacci.fibonacci(NUMBER_N_MINUS_1)
            BigInteger resultN_MINUS_2 = Fibonacci.fibonacci(NUMBER_N_MINUS_2)
        then:
            resultN == ( resultN_MINUS_1.add(resultN_MINUS_2) )
    }



}
