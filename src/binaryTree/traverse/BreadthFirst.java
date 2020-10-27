package binaryTree.traverse;

import binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirst {
    private class TreeNodeQueueNode {
        int level;
        TreeNode node;

        public TreeNodeQueueNode( TreeNode node, int level) {
            this.level = level;
            this.node=node;
        }
    }

    public static void main(String[] args) {
        BreadthFirst breathFirst = new BreadthFirst();
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20,node15,node7);
        TreeNode root = new TreeNode(3,node9,node20);
        breathFirst.levelOrder(root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        List<TreeNodeQueueNode> queue= new ArrayList<>();
        int lastLevel = 0;
        if (root==null) return list;
        queue.add(new TreeNodeQueueNode(root,0));
        List<Integer> currentList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNodeQueueNode queueNode = queue.remove(0);
            if (queueNode.node == null) continue;
            if (lastLevel < queueNode.level){
                list.add(currentList);
                currentList=new ArrayList<>();
                lastLevel=queueNode.level;
            }
            currentList.add(queueNode.node.val);
            queue.add(new TreeNodeQueueNode(queueNode.node.left,queueNode.level+1));
            queue.add(new TreeNodeQueueNode(queueNode.node.right,queueNode.level+1));
        }
        list.add(currentList);

        return list;
    }
}
