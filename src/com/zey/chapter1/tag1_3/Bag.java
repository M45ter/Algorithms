package com.zey.chapter1.tag1_3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<T> implements Iterable<T> {

    private Node<T> first;

    private int n;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Bag() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void add(T t) {
        Node<T> old = first;
        first = new Node<T>();
        first.item = t;
        first.next = old;
        n++;
    }

    public int size(){
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>(first);
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
