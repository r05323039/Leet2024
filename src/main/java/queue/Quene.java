package queue;

public interface Quene<E> {

    boolean offer(E value);

    E poll();

    E peek();

    boolean isEmpty();
}
