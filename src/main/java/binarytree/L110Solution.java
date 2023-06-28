package binarytree;

public class L110Solution {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return (Math.abs(countHeight(root.left)-countHeight(root.right))<=1)&&isBalanced(root.left)&&isBalanced(root.right);
    }
    private int countHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(countHeight(node.left),countHeight(node.right))+1;
    }
}
