package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//锯齿形层序遍历
public class L103Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        Deque<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        boolean direction=false;
        TreeNode point=root;
        queue.offer(point);
        while(!queue.isEmpty()){
            Deque<Integer> floor=new LinkedList<>();
            int temp=queue.size();
            for(int i=0;i<temp;i++){
                point = queue.poll();
                if(direction){
                    floor.push(point.val);
                }else{
                    floor.offer(point.val);
                }
                if(point.left!=null){
                    queue.offer(point.left);
                }
                if(point.right!=null){
                    queue.offer(point.right);
                }
            }
            res.add(new LinkedList<>(floor));
            direction=!direction;
        }
        return res;
    }
}
