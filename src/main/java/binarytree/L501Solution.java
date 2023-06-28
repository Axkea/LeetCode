package binarytree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L501Solution {
    private Set<Integer> iset=new HashSet<>();
    private int maxCount=0;
    private int cur_val=0;
    private int cur_count=0;
    public int[] findMode(TreeNode root) {
        cur_val=root.val;
        showAll(root);
        int[] res=new int[iset.size()];
        int cur=0;
        for(Integer i:iset){
            res[cur]=i;
            cur++;
        }
        return res;
    }
    public void showAll(TreeNode node){
        if(node==null){
            return;
        }
        showAll(node.left);
        if(node.val==cur_val){
            cur_count++;
        }else{
            cur_val= node.val;
            cur_count=1;
        }
        if(cur_count>maxCount){
            maxCount=cur_count;
            iset.clear();
            iset.add(cur_val);
        }
        if(cur_count==maxCount){
            iset.add(cur_val);
        }
        showAll(node.right);
    }
}
