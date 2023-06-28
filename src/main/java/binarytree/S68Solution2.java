package binarytree;

public class S68Solution2 {
    private TreeNode res;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursion(root, p, q);
        return res;
    }
    private boolean recursion(TreeNode root, TreeNode p, TreeNode q){
        if(root==null){
            return false;
        }
        boolean flag1 = recursion(root.left, p, q);
        boolean flag2 = recursion(root.right, p, q);
        if((flag1&&flag2)||((flag1||flag2)&&(root==p||root==q))){
            res=root;
        }
        return flag1||flag2||root==p||root==q;
    }
}
