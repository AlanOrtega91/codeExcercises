package binaryTree.traverse;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PreOrder extends TraverseBinaryTree{
    public static void main(String[] args) {
        PreOrder preorderTraversal = new PreOrder();
        TreeNode subLeft = new TreeNode(3);
        TreeNode right = new TreeNode(2,subLeft,null);
        TreeNode root = new TreeNode(1,null,right);
        preorderTraversal.preorderTraversal(root);
    }

    private void traverse(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }
        list.add(node.val);

        if (this.isLastNode(node)) { return; }


        if (node.left != null){
            traverse(node.left,list);
        }

        if (node.right != null){
            traverse(node.right,list);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root,list);

        return list;
    }
}
