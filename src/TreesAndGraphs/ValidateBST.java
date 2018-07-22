package TreesAndGraphs;

import CtCILibrary.TreeNode;

import static TreesAndGraphs.MinimalTree.minimalTree;

public class ValidateBST {

    public static Boolean validateBinarySearchTree(TreeNode root) {
        if (root == null) return true;

        boolean res;

        if (root.left != null && root.right != null) {
            res = root.left.data <= root.data && root.data <= root.right.data;
        } else if (root.left != null) {
            res = root.left.data <= root.data;
        } else if (root.right != null) {
            res = root.data <= root.right.data;
        } else {
            res = true;
        }

        if (res) {
            return validateBinarySearchTree(root.left) && validateBinarySearchTree(root.right);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,10,8,9,10,11,12,13,14,15, 16};
        TreeNode tree = minimalTree(array);
        tree.print();
        System.out.println(validateBinarySearchTree(tree));
    }
}
