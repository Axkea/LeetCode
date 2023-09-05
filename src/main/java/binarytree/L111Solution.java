package binarytree;

public class L111Solution {
    public int minDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left=minDepth(root.left);
        int right=minDepth(root.right);
        if (left==0||right==0){
            return left==0?right+1:left+1;
        }
        return Math.min(left,right)+1;
    }
}
