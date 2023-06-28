package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class L104Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return left>right?left+1:right+1;
    }
}
