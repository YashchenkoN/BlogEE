package com.blogger.converter;

/**
 * @author Nikolay Yashchenko
 */
public interface Converter<T, U> {
    U convert(T object);
}
