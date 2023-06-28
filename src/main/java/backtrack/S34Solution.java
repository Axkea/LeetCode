package backtrack;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class S34Solution {
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ilist=new ArrayList<>();
        backTrace(res,root,target,ilist);
        return res;
    }
    private void backTrace(List<List<Integer>> res,TreeNode now,int target_remain,List<Integer> ilist){
        if(now==null){
            return;
        }
        target_remain-=now.val;
        ilist.add(now.val);
        //注意判断now为根节点
        if(target_remain==0&&now.left==null&&now.right==now){
            res.add(new ArrayList<>(ilist));
        }
        backTrace(res,now.left,target_remain,ilist);
        backTrace(res,now.right,target_remain,ilist);
        target_remain+=now.val;
        ilist.remove(ilist.size()-1);
    }
}
