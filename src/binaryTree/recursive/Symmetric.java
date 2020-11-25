package binaryTree.recursive;

import binaryTree.Main;
import binaryTree.TreeNode;

public class Symmetric extends Main {
    public static void main(String[] args) {
        Symmetric symmetric = new Symmetric();
        boolean isSymmetric = symmetric.isSymmetric(symmetric.getRoot());
        System.out.println(isSymmetric);
    }

    boolean rootValueIsEqual(TreeNode<Number> node1, TreeNode<Number> node2) {
        return node1!=null && node2 != null && node1.val == node2.val;
    }

    boolean isMirror(TreeNode<Number> node1, TreeNode<Number> node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        return rootValueIsEqual(node1, node2) &&
                isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public boolean isSymmetric(TreeNode<Number> root) {
        return isMirror(root, root);
    }
}