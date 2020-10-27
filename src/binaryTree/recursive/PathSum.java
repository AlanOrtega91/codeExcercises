package binaryTree.recursive;

import binaryTree.Main;
import binaryTree.TreeNode;

public class PathSum extends Main {
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        boolean hasPathSum = pathSum.hasPathSum(pathSum.getRoot(),22);
        System.out.println(hasPathSum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null){
            return false;
        }
        int newSum = sum-root.val;

        if (newSum == 0 && root.left==null && root.right==null){
            return true;
        }

        return hasPathSum(root.left,newSum) || hasPathSum(root.right,newSum);
    }
}
