/**
 * @author KusyapkulovFanzil (5kla@mail.ru)
 */

import java.util.Arrays;


public class MyDec<E> {
    private E[] arr;
    private int begin = 0;
    private int end = 0;
    private int size = 0;
    private double loadFactor = 0.75;

    public MyDec() {
        this(1);
    }

    public MyDec(int num) {
        this(num, 0.75);
    }

    public MyDec(int num, double loadFactor) {
        setLoadFactor(loadFactor);
        if (num > 0) {
            arr = (E[]) new Object[num];
        } else {
            throw new IllegalArgumentException();
        }
    }


    public void addRight(E value) {
        size++;
        expand();
        arr[end] = value;
        end = nextIndex(end);
    }

    public void addLeft(E value) {
        size++;
        expand();
        begin = lastIndex(begin);
        arr[begin] = value;
    }

    public E peekRight() {
        if (size <= 0) {
            throw new StackOverflowError("size == 0");
        }
        return arr[begin];
    }

    public E peekLeft() {
        if (size <= 0) {
            throw new StackOverflowError("size == 0");
        }
        return arr[lastIndex(end)];
    }


    public E removeRight() {
        E value = peekRight();
        size--;
        arr[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public E removeLeft() {
        E value = peekLeft();
        size--;
        end = lastIndex(end);
        arr[end] = null;
        return value;
    }

    private int nextIndex(int index) {
        return (index + 1) % arr.length;
    }

    private int lastIndex(int index) {
        return (arr.length + index - 1) % arr.length;
    }

    public void info() {
        System.out.print(Arrays.toString(arr));
        System.out.printf("begin: %d end: %d size %d \n", begin, end, size);
    }

    private final void setLoadFactor(double loadFactor) {
        if (loadFactor > 0 && loadFactor < 1) {
            this.loadFactor = loadFactor;
        }
    }

    private void expand() {
        if ((double) size / arr.length > loadFactor) {
            E[] tempArr = (E[]) new Object[arr.length * 2];
            if (begin <= end) {
                System.arraycopy(arr, 0, tempArr, 0, arr.length);
            } else {
                System.arraycopy(arr, 0, tempArr, 0, end);
                int newBegin = tempArr.length - arr.length + begin;
                System.arraycopy(arr, begin, tempArr, newBegin, arr.length - begin);
                begin = newBegin;
            }
            arr = tempArr;
        }
    }
}
