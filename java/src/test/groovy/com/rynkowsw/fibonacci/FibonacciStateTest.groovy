package com.rynkowsw.fibonacci

import spock.lang.Specification

/**
 * Created by wojciech on 27.06.17.
 */
class FibonacciStateTest extends Specification {

    BigInteger[] ANY_BIGINTEAGERS_VALUE = [new BigInteger("222222224422222"), new BigInteger("22211222222222222"), new BigInteger("222223322222222")]
    BigInteger ANY_BIGINTEAGER_VALUE = new BigInteger("222222224422222")

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

    def 'first fibonacci state current value is zero, and there is not defined previous value' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
            FibonacciState nextState = fibonacciState.getNextFibonacciState()
        when:
            BigInteger value = nextState.fibonacciValue()
            BigInteger prevValue = nextState.previousFibonacciValue()
        then:
            (BigInteger.ZERO) == value
        and: 'there is not defined previous value in first state'
            null == prevValue
    }

    def 'second fibonacci state current value is one, on this state previous fibonacci value is defined as 0' () {
        given:
            FibonacciState fibonacciState = new FibonacciState()
        when:
            FibonacciState  firstState = fibonacciState.getNextFibonacciState()
            FibonacciState  secondState = firstState.getNextFibonacciState()

            BigInteger value = secondState.fibonacciValue()
            BigInteger prevValue = secondState.previousFibonacciValue()
        then:
            (BigInteger.ONE) == value
        and: 'previous value for this state is zero'
            (BigInteger.ZERO) == prevValue
    }

    def 'third state and nexts fibonacci sates current values are sum of two previous one' () {
        given: 'defined current and previous value, values are not mocked because of problem BigInteger mocking'
            BigInteger currentValue = ANY_BIGINTEAGERS_VALUE[0]
            BigInteger prevValue = ANY_BIGINTEAGERS_VALUE[1]
        and:
            BigInteger plannedSummOfPrevAndCurrentValue = ANY_BIGINTEAGERS_VALUE[2]
        and: 'Class to add two BigIntegers'

            FibonacciNumberCalculator calculator = Mock(FibonacciNumberCalculator) {
                    addTwoNumber(_ as BigInteger, _ as BigInteger) >> plannedSummOfPrevAndCurrentValue
            }
            FibonacciState fibonacciState = new FibonacciState( prevValue, currentValue, calculator)
        when:
            FibonacciState  newState = fibonacciState.getNextFibonacciState()
        then: 'the limit of calculating next big fibonacci number, is memory limitation in adding two BigIntegers'
            plannedSummOfPrevAndCurrentValue == newState.fibonacciValue()
    }

    def 'third state and nexts fibonacci sates contain previous fibonacci value equal to current value of previous state'() {
        given: 'defined current fibonacci value of previous state'
            BigInteger currentValue = new BigInteger("101111111111")
        and:
            FibonacciNumberCalculator calculator = Mock(FibonacciNumberCalculator) {
                addTwoNumber(_ as BigInteger, _ as BigInteger) >> ANY_BIGINTEAGER_VALUE
            }
            FibonacciState fibonacciState = new FibonacciState(  ANY_BIGINTEAGER_VALUE, currentValue, calculator)
        when:
            FibonacciState  state = fibonacciState.getNextFibonacciState()
        then:
            currentValue == state.previousFibonacciValue()
    }

}
