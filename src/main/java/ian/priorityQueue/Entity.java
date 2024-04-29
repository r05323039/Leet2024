package ian.priorityQueue;

public class Entity implements Priority{

    private String name;
    private int priority;
    @Override
    public int priority() {
        return priority;
    }
}
