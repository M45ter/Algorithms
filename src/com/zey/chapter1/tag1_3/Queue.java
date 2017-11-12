package com.zey.chapter1.tag1_3;


import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Queue<T> implements Iterable<T> {

    private Node<T> first;

    private Node<T> last;

    private int n;

    private static class Node<T> {
        private T item;
        private Node<T> next;
    }

    public Queue() {
        first = last = null;
        n = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    private void enqueue(T t) {
        Node<T> oldLast = last;
        last = new Node<T>();
        last.item = t;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        n++;
    }

    private T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T t = first.item;
        first = first.next;
        n--;
        if (isEmpty())
            last = null;
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(first);
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

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                queue.enqueue(item);
            else if (!queue.isEmpty())
                StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + " left on queue)");
    }
}
