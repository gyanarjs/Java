package Generics;

import java.util.Arrays;

public class CustomArrayList {

    private int[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;

    public CustomArrayList() {
        this.data = new int[DEFAULT_CAPACITY];
    }

    public void add(int num) {
        if (isFull()) {
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        int[] temp = new int[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    private boolean isFull() {
        return size == data.length;
    }

    public int remove() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("Cannot remove from an empty list.");
        }
        int removed = data[--size];
        data[size] = 0;  // Optional: Clear the removed element's slot
        return removed;
    }

    public int get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public void set(int index, int value) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        data[index] = value;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" + "data=" + Arrays.toString(Arrays.copyOf(data, size)) + ", size=" + size + "}";
    }

    public static void main(String[] args) {
        CustomArrayList list = new CustomArrayList();
        list.add(3);
        list.add(5);
        list.add(9);
        for (int i = 0; i < 14; i++) {
            list.add(2 * i);
        }

        System.out.println(list);

        list.remove();
        System.out.println(list);

        System.out.println("Element at index 2: " + list.get(2));
        list.set(2, 99);
        System.out.println("After setting index 2 to 99: " + list);
    }
}
