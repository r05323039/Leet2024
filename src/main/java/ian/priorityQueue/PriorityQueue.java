//package ian.priorityQueue;
//
//import ian.queue.Quene;
//
//public class PriorityQueue<E extends Priority> implements Quene<E> {
//
//    Priority[] array;
//    int size;
//
//    public PriorityQueue(int capacity) {
//        this.array = new Priority[capacity];
//    }
//
//    @Override
//    public boolean offer(E value) {
//        if (isFull()) {
//            return false;
//        }
//        int child = size;
//        int parent = (child - 1) / 2;
//        while (child > 0 && value.priority() > array[parent].priority()) {
//            array[child] = array[parent];
//            child = parent;
//            parent = (child - 1) / 2;
//        }
//        array[child] = value;
//        size++;
//        return true;
//    }
//
//    @Override
//    public E poll() {
//        if (isEmpty()) {
//            return null;
//        }
//        E max = (E) array[0];
//        array[0] = array[size - 1];
//        array[size - 1] = null;
//        size--;
//
//        int index = 0;
//        int left = index * 2 + 1;
//        int right = left + 1;
//        E maxx = (E) array[index];
//        while (array[left] != null || array[right] != null) {
//            if (child1.priority() > child2.priority()) {
//                array[index] = child1;
//                array[2 * index + 1] = min;
//                index = 2 * index + 1;
//            } else {
//                array[index] = child2;
//                array[2 * index + 2] = min;
//                index = 2 * index + 2;
//            }
//        }
//
//        return max;
//    }
//
//    private void swag(int a, int b) {
//
//    }
//
//    @Override
//    public E peek() {
//        return null;
//    }
//
//    @Override
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    @Override
//    public boolean isFull() {
//        return size == array.length;
//    }
//}
