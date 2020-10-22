package binaryTree.traverse;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirst {
    public static void main(String[] args) {
        PreOrder preorderTraversal = new PreOrder();
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode root = new TreeNode(3,node9,node20);
        preorderTraversal.preorderTraversal(root);
    }

    private  void traverse(TreeNode node, List<Integer> list){

    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root,list);

        return list;
    }
}
