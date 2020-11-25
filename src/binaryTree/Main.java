package binaryTree;

public class Main {
    public TreeNode getRoot() {
        return root;
    }

    TreeNode<Number> root;

    public Main(){
        TreeNode<Number> root = new TreeNode<Number>(5);
        root.left = new TreeNode<Number>(4);
        root.left.left = new TreeNode<Number>(11);
        root.left.left.left = new TreeNode<Number>(7);
        root.left.left.right = new TreeNode<Number>(2);

        root.right = new TreeNode<Number>(8);
        root.right.left = new TreeNode<Number>(13);
        root.right.right = new TreeNode<Number>(4);
        root.right.right.right = new TreeNode<Number>(1);

        this.root = root;
    }
}
