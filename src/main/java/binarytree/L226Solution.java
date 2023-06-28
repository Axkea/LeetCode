package binarytree;

public class L226Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode point=root.left;
        root.left=invertTree(root.right);
        root.right=invertTree(point);
        return root;
    }
}
