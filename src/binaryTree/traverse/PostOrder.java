package binaryTree.traverse;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args) {
        PostOrder postOrder = new PostOrder();
        TreeNode subLeft = new TreeNode(3);
        TreeNode right = new TreeNode(2,subLeft,null);
        TreeNode root = new TreeNode(1,null,right);
        postOrder.postOrderTraversal(root);
    }

    private  void traverse(TreeNode node, List<Integer> list){
        if (node == null){
            return;
        }

        if (node.left != null){
            traverse(node.left,list);
        }

        if (node.right != null){
            traverse(node.right,list);
        }

        list.add(node.val);
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        traverse(root,list);

        return list;
    }
}
