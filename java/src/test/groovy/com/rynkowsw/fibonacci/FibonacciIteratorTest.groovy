package com.rynkowsw.fibonacci

import spock.lang.Specification

/**
 * Created by wojciech on 25.05.17.
 */
class FibonacciIteratorTest extends Specification {

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
            BigInteger firstElement = iterator.next(),
                       secondElement = iterator.next()
        then:
            secondElement == BigInteger.ONE
    }


    def 'new fibonacci iterator state has initial state' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
        when: 'getting first element'
            FibonacciState fibonacciState = iterator.getFibonacciState()
        then:
            fibonacciState.fibonacciValue() == null
        and:
            fibonacciState.previousFibonacciValue() == null
    }


    def 'fibonacci state after getting first element has defined first element' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
        when: 'getting first element'
            iterator.next();
            FibonacciState fibonacciState = iterator.getFibonacciState()
        then:
            fibonacciState.fibonacciValue() == BigInteger.ZERO
        and:
            fibonacciState.previousFibonacciValue() == null
    }


    def 'fibonacci state after getting second element will has always defined actual and previous fibonacci value' () {
        given:
            FibonacciIterator iterator = new FibonacciIterator()
        when: 'getting second element'
            iterator.next();
            iterator.next();
            FibonacciState fibonacciStateAfterSecondValue = iterator.getFibonacciState()
        then:
            fibonacciStateAfterSecondValue.fibonacciValue() == BigInteger.ONE
        and:
            fibonacciStateAfterSecondValue.previousFibonacciValue() == BigInteger.ZERO
    }


    def 'Iterator use state to create next fibonacci state' (){
        given:
            FibonacciState fibonacciCalculatedStateMock = Mock(FibonacciState.class){
                fibonacciValue() >> new BigInteger(111111111111)
            }

            FibonacciState fibonacciInitialStateMock = Spy(FibonacciState.class){
                previousFibonacciValue() >> BigInteger.ZERO
                fibonacciValue() >> BigInteger.ONE
            }

            FibonacciIterator iteratorWithMocks = new FibonacciIterator(fibonacciInitialStateMock)
        when:
            iteratorWithMocks.next()
        then:
            1 * fibonacciInitialStateMock.getNextFibonaciState() >> fibonacciCalculatedStateMock
            1 * fibonacciCalculatedStateMock.fibonacciValue()
    }

    def 'When iterator state is not initialized, then new state is initialized and first fibonacci value is returned' (){
        given:
            FibonacciIterator iteratorWithMocks = new FibonacciIterator(null)
        when: ' getting next fibonacci for null state'
            BigInteger fibonacciValue = iteratorWithMocks.next()
        then: 'returned first fibonacci value'
            (fibonacciValue.toString()).equals(FibonacciState.FIRST_ELEMENT.fibonacciValue().toString())
    }

}
