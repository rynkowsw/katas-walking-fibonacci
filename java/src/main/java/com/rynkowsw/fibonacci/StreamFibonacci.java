package com.rynkowsw.fibonacci;

import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * Created by wojciech on 24.05.17.
 */
public class StreamFibonacci {

    private Fibonacci fibonacci;

    public StreamFibonacci(){
        fibonacci = new Fibonacci();
    }
    
    public Stream<BigInteger> getFibonnaciStream(){
        return StreamUtils.asStream(fibonacci);
    }

}
