/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
