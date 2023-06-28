package main.title.binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null){
            return res;
        }
        Deque<Node> queue=new LinkedList<>();
        Node point=new Node(root,0,true);
        queue.add(point);
        while(!queue.isEmpty()){
            point=queue.poll();
            if(point.floor==res.size()){
                res.add(new ArrayList<Integer>());
            }
            res.get(point.floor).add(point.val.val);
            if(point.flag){
                if(point.val.right!=null){
                    queue.add(new Node(point.val.right,point.floor+1,false));
                }
                if(point.val.left!=null){
                    queue.add(new Node(point.val.left,point.floor+1,false));
                }
            }else{
                if(point.val.left!=null){
                    queue.add(new Node(point.val.left,point.floor+1,true));
                }
                if(point.val.right!=null){
                    queue.add(new Node(point.val.right,point.floor+1,true));
                }
            }
        }
        return res;
    }
    class Node{
        TreeNode val;
        int floor;
        //右往左为true
        boolean flag;
        public Node(TreeNode val, int floor,boolean flag) {
            this.val = val;
            this.floor=floor;
            this.flag = flag;
        }
    }
}
