package binarytree;

public class L235Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(((root.val>p.val)&&(root.val>q.val))||((root.val<p.val)&&(root.val<q.val))){
            if(p.val>root.val){
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return root;
    }
}
