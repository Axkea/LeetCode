package binarytree;

import java.util.ArrayList;
import java.util.List;

public class L113Solution {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> storage=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root==null){
            return res;
        }
        if (root.left==null&&root.right==null&&root.val==targetSum){
            storage.add(targetSum);
            res.add(storage);
            return res;
        }
        storage.add(root.val);
        backTrance(root, targetSum-root.val);
        return res;
    }

    private void backTrance(TreeNode root, int targetSum){
        if (root.left==null&&root.right==null){
            if (targetSum==0){
                res.add(new ArrayList<>(storage));
            }
            return;
        }
        if (root.left!=null){
            int val=root.left.val;
            storage.add(val);
            backTrance(root.left,targetSum-val);
            storage.remove(storage.size()-1);
        }
        if (root.right!=null){
            int val=root.right.val;
            storage.add(val);
            backTrance(root.right,targetSum-val);
            storage.remove(storage.size()-1);
        }
    }
}
