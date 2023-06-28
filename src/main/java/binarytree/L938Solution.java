package binarytree;

public class L938Solution {
    private int res=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        searchAll(root,low,high);
        return res;
    }
    private void searchAll(TreeNode node,int low,int high){
        if(node==null){
            return;
        }
        if(node.val>=low){
            searchAll(node.left,low,high);
        }
        if(node.val>=low&&node.val<=high){
            res+=node.val;
        }
        if(node.val<=high){
            searchAll(node.right,low,high);
        }
    }
}
