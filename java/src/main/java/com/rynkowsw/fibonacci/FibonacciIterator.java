package com.rynkowsw.fibonacci;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * Created by wojciech on 24.05.17.
 */
public class FibonacciIterator implements Iterator<BigInteger> {

    private FibonacciState iteratorState;

    public FibonacciIterator(){
        this.iteratorState = new FibonacciState();
    }

    public FibonacciIterator(FibonacciState iteratorState){
        this.iteratorState = iteratorState;
    }

    public FibonacciState getFibonacciState(){
        return iteratorState;
    }

    public BigInteger next(){

        if(iteratorState != null ){
            iteratorState =  ( iteratorState.getNextFibonaciState() ) ;
        }  else {
            iteratorState = FibonacciState.FIRST_ELEMENT;
        }
        return iteratorState.fibonacciValue();

    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
