import java.util.Arrays;
import java.util.Objects;

public class MyQueue<T> {
    private static final int DEFAULT_CAPACITY = 5;
    private Object[] elements = new Object[DEFAULT_CAPACITY];
    private int size;

    public void add(Object value) {
        resizeIfNeeded();
        elements[size] = value;
        size++;
    }

    private void resizeIfNeeded() {
        if (elements.length == size) {
            Object[] arr = new Object[elements.length * 2];
            System.arraycopy(elements, 0, arr, 0, size);
            elements = arr;
        }
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(elements, index + 1, elements, index, size - index);
        size--;
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }


    public T peek() {
        try {
            return (T) elements[size - 1];
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("array is empty");
        }
    }

    public T pool() {
        T element = peek();
        elements[size - 1] = null;
        size--;
        return element;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}