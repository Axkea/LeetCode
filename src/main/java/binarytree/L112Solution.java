package binarytree;

public class L112Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.left==null&&root.right==null){
            return root.val==targetSum;
        }
        return isAccess(root,targetSum-root.val);
    }
    private boolean isAccess(TreeNode root, int targetSum){
        if (root.left==null&&root.right==null){
            return targetSum==0;
        }
        boolean isAccess =false;
        if (root.left!=null){
            targetSum-=root.left.val;
            isAccess|=isAccess(root.left,targetSum);
            targetSum+=root.left.val;
        }
        if (root.right!=null){
            targetSum-=root.right.val;
            isAccess|=isAccess(root.right,targetSum);
            targetSum+=root.right.val;
        }
        return isAccess;
    }
}
