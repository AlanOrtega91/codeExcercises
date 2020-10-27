package binaryTree.traverse;

import binaryTree.TreeNode;
import org.jetbrains.annotations.NotNull;

public abstract class TraverseBinaryTree {

    Boolean isLastNode(@NotNull TreeNode node){
        return node.left == null && node.right == null;
    }
}
