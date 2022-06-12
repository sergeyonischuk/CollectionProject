import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
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

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        return "MyArrayList{" +
                "elements=" + Arrays.toString(elements) +
                ", size=" + size +
                '}';
    }
}