package TreesAndGraphs;

import CtCILibrary.TreeNode;
import jdk.nashorn.api.tree.Tree;

import static TreesAndGraphs.MinimalTree.minimalTree;

public class SuccessorInBST {

    public static TreeNode succesor(TreeNode node) {
        if (node == null) return null;

        TreeNode successor = node;

        if (node.right != null) {
            successor = successor.right;
            while (successor.left != null) successor = successor.left;
        } else {
            while (successor.parent != null && successor.parent.data <= node.data) successor = successor.parent;
            if (successor.parent != null) {
                successor = successor.parent;
            } else {
                return null;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15, 16};
        TreeNode tree = minimalTree(array);
        tree.print();
        TreeNode rootSuccesor = tree;
        while (rootSuccesor != null) {
            rootSuccesor = succesor(rootSuccesor);
            if (rootSuccesor != null) System.out.println(rootSuccesor.data);
        }
    }
}
