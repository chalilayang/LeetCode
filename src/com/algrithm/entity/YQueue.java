package com.algrithm.entity;

public class YQueue<T> {

    class Item {
        T data;
        T next;        
    }
    
    private T header;
    private T tail;
}
