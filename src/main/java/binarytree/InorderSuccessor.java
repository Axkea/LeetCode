package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res=null;boolean flag=false;
        //先写出非递归中序遍历
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode point=root;
        while(!stack.isEmpty()||point!=null){
            if (point!=null){
                stack.push(point);
                point=point.left;
            }else{
                point=stack.pop();
                if(flag){
                    res=point;
                    return res;
                }
                if(point==p){
                    flag=true;
                }
                System.out.println(point.val);
                point=point.right;
            }
        }
        return res;
    }
}
