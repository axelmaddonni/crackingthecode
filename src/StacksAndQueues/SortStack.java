package StacksAndQueues;

import CtCILibrary.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> aux = new Stack<>();
        int elems = 0;
        int max = 0;
        boolean first;

        while (! stack.isEmpty()) {
            aux.push(stack.pop());
            elems++;
        }

        while (! aux.isEmpty()) {
            stack.push(aux.pop());
        }

        while (elems > 0) {
            first = true;
            for (int i=0; i < elems; i++) {
                int elem = stack.pop();
                if (first || elem > max) {
                    if (! first) {
                        aux.push(max);
                    } else {
                        first = false;
                    }
                    max = elem;
                } else {
                    aux.push(elem);
                }
            }
            stack.push(max);
            while (! aux.isEmpty()) stack.push(aux.pop());
            elems--;
        }
    }

    public static void sortStack2(Stack<Integer> s) {
        // Ir generando el stack ordenado de mayor a menor en el aux, y despues pasarlo al stack

        boolean first = true;
        Stack<Integer> aux = new Stack<>();

        while (! s.isEmpty()) {
            int elem = s.pop();
            if (aux.isEmpty()) {
                aux.push(elem);
            } else {
                while (! aux.isEmpty() && aux.peek() > elem) {
                    s.push(aux.pop());
                }
                aux.push(elem);
            }
        }

        while (! aux.isEmpty()) {
            s.push(aux.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(4);

        sortStack2(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
