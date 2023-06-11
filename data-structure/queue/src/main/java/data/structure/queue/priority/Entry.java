package data.structure.queue.priority;

/**
 * 优先队列元素
 *
 * @author mexioex
 * @date 2023-06-11
 */
public class Entry implements Priority {
    private final String value;
    private final int priority;

    @Override
    public int priority() {
        return priority;
    }

    public Entry(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "value='" + value + '\'' +
                ", priority=" + priority +
                '}';
    }
}
