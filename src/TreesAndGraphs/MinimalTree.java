package TreesAndGraphs;

import CtCILibrary.TreeNode;
import java.util.BitSet;

public class MinimalTree {

    public static TreeNode minimalTree(int[] array) {
        return minimalTreeAux(array, 0, array.length - 1);
    }

    private static TreeNode minimalTreeAux(int[] array, int start, int end) {
        if (start > end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = minimalTreeAux(array, start, mid - 1);
        if (root.left != null) root.left.parent = root;
        root.right = minimalTreeAux(array, mid + 1, end);
        if (root.right != null) root.right.parent = root;
        return root;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode tree = minimalTree(array);
        tree.print();
    }
}
