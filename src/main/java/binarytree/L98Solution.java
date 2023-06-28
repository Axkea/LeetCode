package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class L98Solution {
    //直接中序遍历判断是否是有效的
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        TreeNode pre=null;
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode point=root;
        while(!stack.isEmpty()||point!=null){
            if (point!=null){
                stack.push(point);
                point=point.left;
            }else{
                point=stack.pop();
                if(pre!=null&&pre.val>=point.val){
                    return false;
                }
                pre=point;
                point=point.right;
            }
        }
        return true;
    }
}
