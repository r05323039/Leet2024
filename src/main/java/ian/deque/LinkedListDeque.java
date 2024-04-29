package ian.deque;

import lombok.AllArgsConstructor;

import java.util.Iterator;

public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    private int capacity;
    private int size;
    private Node<E> sentinel = new Node<>(null, null, null);

    {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
    }

    @AllArgsConstructor
    static class Node<E> {
        E value;
        Node<E> prev;
        Node<E> next;
    }

    @Override
    public boolean offerFirst(E e) {
        if (isFull()) {
            return false;
        }

        Node<E> oldHead = sentinel.next;
        Node<E> added = new Node<>(e, sentinel, oldHead);
        sentinel.next = added;
        oldHead.prev = added;
        size++;
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        if (isFull()) {
            return false;
        }
        Node<E> oldTail = sentinel.prev;
        Node<E> added = new Node<>(e, oldTail, sentinel);
        sentinel.prev = added;
        oldTail.next = added;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<E> polled = sentinel.next;
        Node<E> newHead = polled.next;
        sentinel.next = newHead;
        newHead.prev = sentinel;
        size--;
        return polled.value;
    }

    @Override
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        Node<E> polled = sentinel.prev;
        Node<E> newTail = polled.prev;
        sentinel.prev = newTail;
        newTail.next = sentinel;
        size--;
        return polled.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return sentinel.prev.value;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public E next() {
                Node<E> node = p;
                p = p.next;
                return node.value;
            }
        };
    }
}
