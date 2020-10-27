package binaryTree.recursive;

import binaryTree.Main;
import binaryTree.TreeNode;

public class MaxDepth  extends Main {
    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        maxDepth.maxDepth(maxDepth.getRoot());
    }

    public int maxDepth(TreeNode root){
        if (root==null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
}
