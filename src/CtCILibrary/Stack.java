package CtCILibrary;

import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> array = new ArrayList<>();

    public T peek() {
        if (array.size() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array.get(array.size() - 1);
    }

    public T pop() {
        if (array.size() == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array.remove(array.size() - 1);
    }

    public void push(T elem) {
        array.add(elem);
    }

    public Boolean isEmpty() {
        return array.size() == 0;
    }
}
