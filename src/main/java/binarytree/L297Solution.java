package binarytree;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L297Solution {
    // Encodes a tree to a single string.
    //使用bfs实现将树转化为字符串
    public String serialize(TreeNode root) {
        if(root==null){
            return "#";
        }
        StringBuilder sb=new StringBuilder();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode point=null;
        while(!queue.isEmpty()){
            point=queue.pop();
            if(point==null){
                sb.append("#,");
                continue;
            }
            sb.append(point.val+",");
            queue.add(point.left);
            queue.add(point.right);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("#")){
            return null;
        }
        String[] split = data.split(",");
        TreeNode root=new TreeNode(Integer.parseInt(split[0]));
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        TreeNode point=null;
        for (int i = 1; i < split.length; i++) {
            point=queue.pop();
            if(!"#".equals(split[i])){
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                point.left=node;
                queue.add(node);
            }
            if(!"#".equals(split[++i])){
                TreeNode node = new TreeNode(Integer.parseInt(split[i]));
                point.right=node;
                queue.add(node);
            }
        }
        return root;
    }
}
