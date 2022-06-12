import java.util.Objects;

public class MyStack<T> {
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
            return (T) elements[0];
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException("array is empty");
        }
    }

    public T pop () {
        T element = peek();
        Object[] arr = new Object[elements.length - 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = elements[i];
        }
        elements = arr;
        return element;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();

        for (Object element : elements) {
            builder.append(element);
        }
        return builder.toString();
    }
}
