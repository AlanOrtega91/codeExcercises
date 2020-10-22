package binaryTree.traverse;

import java.util.ArrayList;
import java.util.List;

public class PostOrder {
    public static void main(String[] args) {
        InOrder inOrder = new InOrder();
        TreeNode subLeft = new TreeNode(3);
        TreeNode right = new TreeNode(2,subLeft,null);
        TreeNode root = new TreeNode(1,null,right);
        inOrder.inorderTraversal(root);
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
