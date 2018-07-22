package BitManipulation;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;

public class UniqueIds {

    public static class UniqueIdsGenerator {
        private MyBitSet bitset;
        private int maxNumber;

        public UniqueIdsGenerator(int max) {
            bitset = new MyBitSet(max);
            maxNumber = max;
        }

        public int getUniqueNumber(Collection<Integer> released) {
            for(int elem: released) {
                bitset.set(elem, false);
            }

            int i = 1;
            while (i <= maxNumber) {
                if (! bitset.get(i)) {
                    bitset.set(i, true);
                    break;
                }
                i++;
            }
            if (i == maxNumber + 1) {
                throw new RuntimeException();
            }
            System.out.println(i);
            return i;
        }
    }

    public static class MyBitSet {
        private int[] words;

        public MyBitSet(int size) {
            words = new int[(size >> 5) + 1];
        }

        public boolean get(int pos) {
            int wordNumber = pos >> 5;
            int offset = pos % 32;
            return (words[wordNumber] & (1 << offset)) != 0;
        }

        public void set(int pos, boolean value) {
            int wordNumber = pos >> 5;
            int offset = pos % 32;
            int newValue = ~(1 << offset);
            words[wordNumber] &= newValue;
            if (value) {
                words[wordNumber] |= (1 << offset);
            }
        }
    }

    public static void main(String[] args) {
        UniqueIdsGenerator generator = new UniqueIdsGenerator(10);

        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>() {{ add(1); add(2); }});
        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>() {{ add(4); add(6); }});
        generator.getUniqueNumber(new ArrayList<>());
        generator.getUniqueNumber(new ArrayList<>());


    }
}
