package split_merge;

import binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class L95Solution {
    public List<TreeNode> generateTrees(int n) {
        return split(1,n);
    }
    private List<TreeNode> split(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if(start>end){
            res.add(null);
            return res;
        }
        if(start==end){
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <=end ; i++) {
            for(TreeNode leftNode:split(start,i-1)){
                for(TreeNode rightNode:split(i+1,end)){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
