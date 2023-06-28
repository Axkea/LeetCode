package binarytree;

public class S68Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null){
           return null;
       }
        TreeNode t1=lowestCommonAncestor(root.left,p,q);
        TreeNode t2=lowestCommonAncestor(root.right,p,q);
        if((root.val<=p.val&&root.val>=q.val)||(root.val>=p.val&&root.val<=q.val)){
            return root;
        }
        if(t1!=null){
            return t1;
        }else if(t2!=null){
            return t2;
        }
        return null;
    }
}
