package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class L99Solution {
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode p=root;
        TreeNode x=null,y=null,pre=null;
        while (p!=null||!stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p=p.left;
            }else{
                p= stack.pop();
                if (pre!=null&&pre.val>p.val){
                    if (x==null){
                        x=pre;
                    }
                    y=p;
                }
                pre=p;
                p=p.right;
            }
        }
        int tmp=x.val;
        x.val=y.val;
        y.val=tmp;
    }
}
