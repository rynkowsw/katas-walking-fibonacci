package com.rynkowsw.fibonacci;

import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by wojciech on 24.05.17.
 */
public class StreamUtils {

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
        return asStream(sourceIterator, false);
    }

    public static <T> Stream<T> asStream(Iterator<T> sourceIterator, boolean parallel) {
        Iterable<T> iterable = () -> sourceIterator;
        return StreamSupport.stream(iterable.spliterator(), parallel);
    }
}
