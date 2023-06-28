package binarytree;

import java.util.ArrayList;
import java.util.List;

public class L257Solution {
    private List<String> list=new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,"");
        return list;
    }
    private void dfs(TreeNode node,String s){
        if(node.left==null&&node.right==null){
            list.add(s+node.val);
            return;
        }
        if(node.left!=null){
            dfs(node.left,s+node.val+"->");
        }
        if(node.right!=null){
            dfs(node.right,s+node.val+"->");
        }
    }
}
