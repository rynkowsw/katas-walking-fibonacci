package com.rynkowsw.fibonacci;

import java.math.BigInteger;

/**
 * Created by wojciech on 11.06.17.
 */
public class FibonacciState {

    private BigInteger previousValue, currentValue;

    private FibonacciNumberCalculator fibonacciNumberCalculator;

    public static final FibonacciState FIRST_ELEMENT = new FibonacciState(null, BigInteger.ZERO, new FibonacciNumberCalculator());

    public static final FibonacciState SECOND_ELEMENT = new FibonacciState(BigInteger.ZERO, BigInteger.ONE, new FibonacciNumberCalculator() );

    public FibonacciState(){
        previousValue = null;
        currentValue=null;
        fibonacciNumberCalculator= new FibonacciNumberCalculator();
    }

    public FibonacciState(BigInteger n_1IteratorValue, BigInteger nIteratorValue, FibonacciNumberCalculator fibonacciNumberCalculator) {
        this.previousValue = n_1IteratorValue;
        this.currentValue = nIteratorValue;
        this.fibonacciNumberCalculator = fibonacciNumberCalculator;
    }



    public FibonacciState getNextFibonaciState(){

        BigInteger  previousValue = newInstanceOfFibonacciValue(this.previousValue),
                    currentValue = newInstanceOfFibonacciValue(this.currentValue);

        if( this.isAfterGettingSecondElement() ){

            BigInteger nextFibonacciValue = fibonacciNumberCalculator.addTwoNumber(previousValue, currentValue);

            return new FibonacciState(
                    currentValue,
                    nextFibonacciValue,
                    fibonacciNumberCalculator
            );


        } else if (this.isAfterGettingFirstElement()) {
            return SECOND_ELEMENT;
        }
        else {
            return FIRST_ELEMENT;
        }
    }

    public BigInteger previousFibonacciValue() {
        return newInstanceOfFibonacciValue(previousValue);
    }


    public BigInteger fibonacciValue() {
        return newInstanceOfFibonacciValue(currentValue);
    }



    private BigInteger newInstanceOfFibonacciValue(BigInteger fibonacciValue) {

        if(fibonacciValue == null)
            return null;

        return new BigInteger(fibonacciValue.toString());
    }

    private boolean isAfterGettingSecondElement(){

        if(currentValue == null || previousValue == null)
            return false;

        boolean currentValueBiggerThanOne = (BigInteger.ONE).compareTo(currentValue) < 0;
        boolean previousValueBiggerThanZero = (BigInteger.ZERO).compareTo(previousValue) <= 0;

        return currentValueBiggerThanOne && previousValueBiggerThanZero;
    }

    private boolean isAfterGettingFirstElement(){
        return currentValue != null && BigInteger.ZERO.compareTo(currentValue) == 0 && previousValue == null;
    }

}
