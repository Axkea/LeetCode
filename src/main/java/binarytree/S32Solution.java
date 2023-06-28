package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S32Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null){
            return new int[0];
        }
        Deque<TreeNode> queue=new LinkedList<>();
        List<Integer> ilist =new ArrayList<>();
        queue.add(root);
        while(queue.size()!=0){
            TreeNode pop = queue.pop();
            ilist.add(pop.val);
            if(pop.left!=null){
                queue.add(pop.left);
            }
            if(pop.right!=null){
                queue.add(pop.right);
            }
        }
        int[] res=new int[ilist.size()];
        for(int i=0;i<ilist.size();i++){
            res[i]=ilist.get(i);
        }
        return res;
    }
 }
