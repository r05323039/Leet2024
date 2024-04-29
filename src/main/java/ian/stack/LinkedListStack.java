package ian.stack;

import lombok.AllArgsConstructor;

import java.util.Iterator;

class LinkedListStack<E> implements Stack<E>, Iterable<E> {

    private Node<E> head = new Node<>(null, null);
    private int capacity;
    private int size = 0;

    public LinkedListStack(int capacity) {
        this.capacity = capacity;
    }

    @AllArgsConstructor
    static class Node<E> {
        private E value;
        private Node<E> next;
    }

    @Override
    public boolean push(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(value, head);
        head = added;
        size++;
        return true;
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            return null;
        }
        Node<E> pop = head;
        head = head.next;
        size--;
        return pop.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> p = head;

            @Override
            public boolean hasNext() {
                return p.next != null;
            }

            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
