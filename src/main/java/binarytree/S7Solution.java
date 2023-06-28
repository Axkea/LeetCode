package binarytree;

import java.util.Arrays;

public class S7Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return recursion(preorder,inorder,0,preorder.length,0,inorder.length);
    }
    private TreeNode recursion(int[] preorder, int[] inorder,int pbegin ,int pend,int ibegin,int iend){
        if(pbegin>pend){
            return null;
        }
        TreeNode root=new TreeNode(preorder[pbegin]);
        int count=0;
        for (int i = ibegin; i < iend; i++) {
            if(inorder[i]==preorder[0]){
                count=i;
            }
        }
        int leftNum=count-ibegin;
        TreeNode left=recursion(preorder,inorder,pbegin+1,pbegin+1+leftNum,ibegin,count);
        TreeNode right=recursion(preorder,inorder,pbegin+1+leftNum,pend,count+1,iend);
        root.left=left;
        root.right=right;
        return root;
    }
}
