package binarytree;

public class S55Solution2 {
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        return Math.abs(deep(root.left)-deep(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }
    public int deep(TreeNode node){
        if(node==null){
            return 0;
        }
        return Math.max(deep(node.left),deep(node.right))+1;
    }
}
