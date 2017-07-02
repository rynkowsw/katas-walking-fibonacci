package com.rynkowsw.fibonacci

import spock.lang.Specification

/**
 * Created by wojciech on 27.06.17.
 */
class FibonacciStateTest extends Specification {

    def 'initial fibonacci state has empty fibonacci value' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
        when:
            BigInteger value = fibonacciState.fibonacciValue()
        then:
            value == null
    }

    def 'initial fibonacci state has empty previous fibonacci value' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
        when:
            BigInteger value = fibonacciState.previousFibonacciValue()
        then:
            value == null
    }

    def 'first fibonacci value is zero, and there is not defined previous value in this state' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
            FibonacciState nextState = fibonacciState.getNextFibonaciState()
        when:
            BigInteger value = nextState.fibonacciValue()
            BigInteger prevValue = nextState.previousFibonacciValue()
        then:
            (BigInteger.ZERO) == value
        and: 'there is not defined previous value in first state'
            null == prevValue
    }

    def 'second fibonacci value is one, on this state previous fibonacci value is defined' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
        when:
            FibonacciState  firstState = fibonacciState.getNextFibonaciState()
            FibonacciState  secondState = firstState.getNextFibonaciState()

            BigInteger value = secondState.fibonacciValue()
            BigInteger prevValue = secondState.previousFibonacciValue()
        then:
            (BigInteger.ONE) == value
        and: 'previous value for this state is zero'
            (BigInteger.ZERO) == prevValue
    }

    def 'third and next fibonacci values are sum of two previous one' () {
        given: 'state with defined current and previous value, values are not mocked because of problem BigInteger mocking'
            BigInteger currentValue = new BigInteger("101111111111")
            BigInteger prevValue = new BigInteger("201111111111111111")
            BigInteger plannedSummOfPrevAndCurrentValue = new BigInteger("30111111111111111111")
        and:'Two BigInteger sum class, the limit of calculating next big fibonacci number, is memory limit of BigInteger.add function'
            FibonacciNumberCalculator calculator = Mock(FibonacciNumberCalculator) {
                addTwoNumber(_ as BigInteger, _ as BigInteger) >> plannedSummOfPrevAndCurrentValue

            }
            FibonacciState fibonacciState = new FibonacciState( prevValue, currentValue, calculator)
        when:
            FibonacciState  state = fibonacciState.getNextFibonaciState()
        then:
            currentValue == state.previousFibonacciValue()
        and:
            plannedSummOfPrevAndCurrentValue == state.fibonacciValue()
    }




}
