package TreesAndGraphs;

import CtCILibrary.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;

import static TreesAndGraphs.MinimalTree.minimalTree;

public class ListOfDepths {

    public static ArrayList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {

        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) {
            current.add(root);
            result.add(current);
        }

        while (current.size() > 0) {
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) current.addLast(parent.left);
                if (parent.right != null) current.addLast(parent.right);
            }
            result.add(current);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15, 16};
        TreeNode tree = minimalTree(array);
        tree.print();
        ArrayList<LinkedList<TreeNode>> lists = listOfDepths(tree);
        for (LinkedList<TreeNode> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i).data);
            }
            System.out.println("");
        }
    }
}
