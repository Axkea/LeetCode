package BFS_DFS;

import binarytree.TreeNode;

public class S49Solution2 {
    public int sumNumbers(TreeNode root) {
        int[] res=new int[1];
        backTrace(root,new StringBuilder(),res);
        return res[0];
    }
    private void backTrace(TreeNode now,StringBuilder sb,int[] res){
        if(now.left==null&&now.right==null){
            sb.append(now.val);
            Integer integer = Integer.valueOf(new String(sb));
            res[0]+=integer;
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        sb.append(now.val);
        backTrace(now.left,sb,res);
        backTrace(now.right,sb,res);
        sb.deleteCharAt(sb.length()-1);
    }
}
