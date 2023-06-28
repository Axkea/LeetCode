package binarytree;

public class L701Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            return new TreeNode(val);
        }
        int val1=root.val;
        if(val1>val){
            root.left=insertIntoBST(root.left,val);
        }else if(val1<val){
            root.right=insertIntoBST(root.right,val);
        }
        return root;
    }
}
