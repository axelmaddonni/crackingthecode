package StacksAndQueues;

public class StackWithMinimum {

    public static class StackWithMin {

        private NodeWithMin[] array;
        private int last = 0;


        public StackWithMin(int size) {
            array = new NodeWithMin[size];
        }

        public void push(int value) {
            if (last == array.length) {
                throw new RuntimeException();
            }
            int min;
            if (last == 0) {
                min = value;
            } else {
                min = Math.min(array[last-1].min, value);
            }
            array[last] = new NodeWithMin(value, min);
            last++;
        }

        public int pop() {
            if (last == 0) {
                throw new RuntimeException();
            }
            last--;
            return array[last].value;
        }

        public int min() {
            return array[last-1].min;
        }

        public static class NodeWithMin {
            public int value;
            public int min;

            public NodeWithMin(int value, int min) {
                this.value = value;
                this.min = min;
            }
        }
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin(10);
        stack.push(2);
        stack.push(10);
        stack.push(5);
        stack.push(1);
        stack.push(4);

        System.out.println(stack.min());

        stack.pop();
        stack.pop();

        System.out.println(stack.min());
    }

}

