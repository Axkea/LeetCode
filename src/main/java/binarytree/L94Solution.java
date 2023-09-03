package binarytree;

import java.util.ArrayList;
import java.util.List;

public class L94Solution {
    private List<Integer> res=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        mid(root);
        return res;
    }

    private void mid(TreeNode root){
        if (root==null){
            return;
        }
        mid(root.left);
        res.add(root.val);
        mid(root.right);
    }
}
