package binaryTree.recursive;

import binaryTree.TreeNode;

import java.util.ArrayList;

/*
    Having the following binary tree:
                    a
            b                   c
        d       e            f      g
      h   i   j   k        l   m   n  o

    return an array that prints counter clockwise the boundary nodes like:

    [a b d h i j k l m n o g c]
 */
public class Boundary {

    ArrayList<Character> boundaries = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode<Character> root = new TreeNode('a',
                new TreeNode('b',
                        new TreeNode("d",
                                new TreeNode("h"), new TreeNode("i")
                        ),
                        new TreeNode("e",
                                new TreeNode("j"), new TreeNode("k")
                        )
                ),
                new TreeNode('c',
                        new TreeNode("f",
                                new TreeNode("l"), new TreeNode("m")
                        ),
                        new TreeNode("g",
                                new TreeNode("n"), new TreeNode("o")
                                )
                )
        );

        Boundary boundary = new Boundary();
        boundary.printBoundaries(root);

        System.out.println(boundary.boundaries.toString());
    }

    void printBoundaries(TreeNode<Character> root){
        if (root == null){
            return;
        }
        boundaries.add(root.val);

        printBoundaries(root.left,true,false);
        printBoundaries(root.right,false, true);
    }

    void printBoundaries(TreeNode<Character> node, boolean leftBoundary, boolean rightBoundary) {
        if (node == null){return;}

        if (node.left == null && node.right == null){
            boundaries.add(node.val);
            return;
        }

        if (leftBoundary) {
            boundaries.add(node.val);
        }

        printBoundaries(node.left,leftBoundary, false);

        printBoundaries(node.right,false, rightBoundary);

        if ( rightBoundary) {
            boundaries.add(node.val);
        }
    }
}
