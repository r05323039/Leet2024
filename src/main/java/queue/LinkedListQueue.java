package queue;

import lombok.AllArgsConstructor;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedListQueue<E> implements Quene<E>, Iterable<E> {
    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;

    public LinkedListQueue() {
        tail.next = head;
    }

    @AllArgsConstructor
    public static class Node<E> {
        private E value;
        private Node<E> next;
    }

    @Override
    public boolean offer(E value) {
        if (value == null) {
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        return true;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head.next;//指向哨兵之外第一個元素

            @Override
            public boolean hasNext() {
                return p != head;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<E> spliterator() {
        return Iterable.super.spliterator();
    }
}
