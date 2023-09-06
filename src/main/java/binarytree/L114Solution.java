package binarytree;

public class L114Solution {
    public void flatten(TreeNode root) {
        while (root!=null){
            if (root.left==null){
                root=root.right;
            }else{
                TreeNode right=root.right;
                root.right=root.left;
                root.left=null;
                TreeNode p=root.right;
                while (p.right!=null){
                    p=p.right;
                }
                p.right=right;
                root=root.right;
            }
        }
    }
}
