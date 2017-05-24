package com.rynkowsw.fibonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;

/**
 * Created by wojciech on 24.05.17.
 */
public class Fibonacci implements Iterator<BigInteger> {
    private int index = 0;

    private final BigInteger firstValue = BigInteger.ZERO, secondValue = BigInteger.valueOf(1);

    private BigInteger a= firstValue, b = secondValue;

    public BigInteger next(){

        BigInteger result;

        switch (index){
            case 0:
                result = firstValue;
                break;
            case 1:
                result = secondValue;
                break;

            default:
                result = a.add(b);
                a = b ;
                b = result;
                break;
        }
        index ++;

        return new BigInteger(result.toString());
    }

    @Override
    public boolean hasNext() {
        return true;
    }
}
