package com.mycompany.ex1;

/**
 *
 * @author szymon
 */
public interface Queue <T> {
     void enqueue(T o);

    T dequeue();

    int size();
}
