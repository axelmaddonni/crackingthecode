package StacksAndQueues;

public class ThreeInOne {

    public static class ThreeStacks {
        private int[] array;
        private int stack1Last;
        private int stack2Last;
        private int stack3Last;

        private int[] last;

        public ThreeStacks(int size) {
            if (size < 3) {
                throw new RuntimeException();
            }
            array = new int[size];
            last = new int[3];
            last[0] = 0;
            last[1] = 1;
            last[2] = 2;
        }

        public void push(int stackNumber, int value) {
            if (last[stackNumber] > array.length) {
                throw new RuntimeException();
            }
            array[last[stackNumber]] = value;
            last[stackNumber] += 3;
        }

        public int peek(int stackNumber) {
            if (last[stackNumber] - 3 < 0) {
                throw new RuntimeException();
            }
            return array[last[stackNumber]-3];
        }

        public int pop(int stackNumber) {
            if (last[stackNumber] - 3 < 0) {
                throw new RuntimeException();
            }
            last[stackNumber] -= 3;
            return array[last[stackNumber]];
        }
    }

    public static void main(String[] args) {

        ThreeStacks stacks = new ThreeStacks(10);
        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(1, 11);
        stacks.push(1, 22);
        stacks.push(1, 33);
        stacks.push(2, 111);
        stacks.push(2, 222);
        stacks.push(2, 333);

        System.out.println(stacks.pop(0));
        System.out.println(stacks.pop(1));
        System.out.println(stacks.pop(2));

        System.out.println(stacks.peek(0));
        System.out.println(stacks.peek(1));
        System.out.println(stacks.peek(2));
    }
}
