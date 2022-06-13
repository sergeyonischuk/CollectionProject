
public class MyHashMap<K, V> {
    private int size;
    private MyNode first;

    public void put(Object key, Object value) {
        if (size == 0) {
            first = new MyNode(key, value);
            size++;
        } else {
            MyNode current = first;
            for (int i = 0; i < size; i++) {
                if (current.next != null) {
                    if (current.key.equals(key)) {
                        current.value = value;
                        break;
                    }
                    current = current.next;
                } else {
                    current.next = new MyNode(key, value);
                    size++;
                }
            }
        }
    }

    public Object get(Object key) {
        if (size > 0) {
            MyNode current = first;
            for (int i = 0; i < size; i++) {
                if (current.key.equals(key)) {
                    System.out.println(current.key + " " + current.value);
                    return current;
                }
                current = current.next;
            }
        }
        return null;
    }


    public void clear() {
        size = 0;
        first = null;
    }

    public int size() {
        return size;
    }


    private class MyNode {
        private Object key;
        private Object value;
        private MyNode next;

        public MyNode(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public void setKey(Object key) {
            this.key = key;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        } else {
            StringBuilder builder = new StringBuilder();
            MyNode current = first;
            for (int i = 0; i < size; i++) {
                builder.append("[key:").append(current.key)
                        .append(" value:").append(current.value).append("]");
                if (current.next != null) {
                    current = current.next;
                }
            }
            return builder.toString();
        }
    }
}
