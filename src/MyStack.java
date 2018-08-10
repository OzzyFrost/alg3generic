/**
 * @author KusyapkulovFanzil (5kla@mail.ru)
 *
 * */

public class MyStack<E> {
    private E[] arr;
    private int size = 0;
    private double loadFactor = 0.75;

    public MyStack() {
        this(1, 0.75);
    }

    public MyStack(int len) {
        this(len, 0.75);
    }

    public MyStack(int len, double loadFactor) {
        setLoadFactor(loadFactor);
        if (len > 0) {
            arr = (E[])new Object[len];
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void push(E value) {
        arr[size++] = value;
        if ((double) size / arr.length > loadFactor) {
            E[] tempArr = (E[])new Object[arr.length * 2];
            System.arraycopy(arr, 0, tempArr, 0, arr.length);
            arr = tempArr;
        }
    }

    public E pop() {
        E res = peek();
        arr[--size]=null;
        return res;
    }

    public E peek() {
        if (size <= 0) {
            throw new StackOverflowError("size == 0");
        }
        return arr[size - 1];
    }

    public void info() {
        System.out.printf("size: %d length: %d\n", size, arr.length);
    }

    private final void setLoadFactor(double loadFactor) {
        if (loadFactor > 0 && loadFactor < 1) {
            this.loadFactor = loadFactor;
        }
    }

    public int size(){
        return size;
    }
}
