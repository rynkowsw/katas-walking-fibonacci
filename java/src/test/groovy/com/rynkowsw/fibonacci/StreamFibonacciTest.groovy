package com.rynkowsw.fibonacci

import java.util.stream.Stream

import spock.lang.Specification

/**
 * Created by wojciech on 03.07.17.
 */
class StreamFibonacciTest extends Specification {

    def 'Stream is created for defined iterator' () {
        given:
            Iterator iteratorStub = new IteratorStub()
            StreamFibonacci streamFibonacci = new StreamFibonacci(iteratorStub)
        when:
            Stream<BigInteger> resultStream = streamFibonacci.getFibonnaciStream()
        then:
            IteratorStub.streamContainsAllIteratorValues(resultStream)

    }



    private class IteratorStub implements Iterator<BigInteger>{

        private static int i = 0;

        @Override
        boolean hasNext() {
            return i<100;
        }

        @Override
        BigInteger next() {
            i++
            return new BigInteger(i)
        }

        static boolean streamContainsAllIteratorValues(Stream<BigInteger> stream){
            int index = i + 1

            List<BigInteger> values = Arrays.asList(stream.toArray())

            for ( BigInteger item : values ){
                if( item.toInteger() != index  ) {
                    println item.toString() + index
                    return false
                }
                index++
            }
            return true
        }

    }

}
