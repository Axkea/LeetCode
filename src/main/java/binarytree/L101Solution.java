package binarytree;

public class L101Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isTheSame(root.left,root.right);
    }
    private boolean isTheSame(TreeNode left,TreeNode right){
        if(left==null&&right==null){
            return true;
        }
        if(left==null||right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return isTheSame(left.right,right.left)&&isTheSame(left.left,right.right);
    }
}
