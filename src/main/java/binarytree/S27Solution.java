package binarytree;

public class S27Solution {
    public TreeNode mirrorTree(TreeNode root) {
        recursion(root);
        return root;
    }
    public void recursion(TreeNode root){
        if(root==null){
            return;
        }
        recursion(root.left);
        recursion(root.right);
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
