package design.pattern.behavioral.iterator;

/**
 * 简单的 String 类型容器
 *
 * @author mexioex
 * @date 2023-06-30
 */
public class StringArray implements Aggregate<String> {
    private final String[] values;

    public StringArray(String[] values) {
        this.values = values;
    }

    @Override
    public Iterator<String> createIterator() {
        return new StringArrayIterator();
    }

    private class StringArrayIterator implements Iterator<String> {
        private int position;

        @Override
        public String next() {
            return values[position++];
        }

        @Override
        public boolean hasNext() {
            return position < values.length;
        }
    }
}
