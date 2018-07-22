package TreesAndGraphs;

import CtCILibrary.TreeNode;

import static TreesAndGraphs.MinimalTree.minimalTree;

public class CheckBalanced {

    public static Boolean checkBalanced(TreeNode root) {
        return checkBalancedAux(root) != -1;
    }

    private static int checkBalancedAux(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;

        int leftHeight = checkBalancedAux(root.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalancedAux(root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(rightHeight - leftHeight) > 1) {
            return -1;
        } else {
            return Math.max(rightHeight, leftHeight) + 1;
        }
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,20,11,12,13,14,15, 16};
        TreeNode tree = minimalTree(array);
        tree.print();
        System.out.println(checkBalanced(tree));
    }
}
