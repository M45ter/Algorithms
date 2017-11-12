package com.zey.chapter1.tag1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {

    private Node<T> top;

    private int n;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Stack() {
        top = null;
        n = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return n;
    }

    public void push(T t) {
        Node<T> old = top;
        top = new Node<T>();
        top.item = t;
        top.next = old;
        n++;
    }

    public T pop() {
        if (isEmpty())
            return null;
        T t = top.item;
        top = top.next;
        n--;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(top);
    }

    private class ListIterator<T> implements Iterator<T> {

        private Node<T> current;

        public ListIterator(Node<T> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            T t = current.item;
            current = current.next;
            return t;
        }
    }
}
