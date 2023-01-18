import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public Object[] getElements() {
        return elements;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(int e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }
    
    public void  remove(int index) {
        for (int i = index; i < size; i++) {
            elements[i]=elements[i+1];
        } size--;
    }

    public MyList<E> clone() {
        MyList<E> copy = new MyList<>();
        copy.elements = Arrays.copyOf(elements,size);
        copy.size = size;
        return copy;
    }
    public boolean contains(E e) {
        return this.indexOf((String) e) >= 0;
    }
    public int indexOf(String e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }
    public boolean add(E arrayList) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size] = arrayList;
        size++;
        return true;
    }

    public E get(int index) {
        return (E) elements [index];
    }
}
