package ian.queue;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Iterator;

@NoArgsConstructor
public class LinkedListQueue<E> implements Quene<E>, Iterable<E> {
    private Node<E> head = new Node<>(null, null);
    private Node<E> tail = head;
    private int size = 0;
    private int capacity = Integer.MAX_VALUE;

    {
        tail.next = head;//所有建構子都調用
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    @AllArgsConstructor
    public static class Node<E> {
        private E value;
        private Node<E> next;
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size++;
        return true;
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        Node<E> removed = head.next;
        head.next = removed.next;
        if (removed == tail) {
            tail = head;
        }
        size--;
        return removed.value;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return head.next.value;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
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
}
