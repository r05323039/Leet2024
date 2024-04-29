package ian.priorityQueue;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Entry implements Priority{

    private String name;
    private int priority;
    @Override
    public int priority() {
        return priority;
    }
}
