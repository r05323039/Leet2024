package ian.stack;

interface Stack<E> {

    boolean push(E value);

    E pop();

    E peek();

    boolean isEmpty();

    boolean isFull();
}
