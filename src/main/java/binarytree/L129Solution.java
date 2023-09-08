package binarytree;

import java.util.ArrayList;
import java.util.List;

public class L129Solution {
    private List<String> stringList =new ArrayList<>();
    public int sumNumbers(TreeNode root) {
        int res=0;
        if (root==null){
            return res;
        }
        StringBuilder builder=new StringBuilder();
        builder.append(root.val);
        backTrack(root,builder);
        for (int i = 0; i < stringList.size(); i++) {
            res+=Integer.valueOf(stringList.get(i));
        }
        return res;
    }

    private void backTrack(TreeNode node,StringBuilder builder){
        if (node.left==null&&node.right==null){
            stringList.add(builder.toString());
            return;
        }
        if (node.left!=null){
            builder.append(node.left.val);
            backTrack(node.left,builder);
            builder.deleteCharAt(builder.length()-1);
        }
        if (node.right!=null){
            builder.append(node.right.val);
            backTrack(node.right,builder);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
