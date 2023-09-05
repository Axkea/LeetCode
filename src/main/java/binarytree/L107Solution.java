package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L107Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<List<Integer>> stack=new LinkedList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode p=null;
        while (!queue.isEmpty()){
            List<Integer> lRes=new ArrayList<>();
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                p=queue.poll();
                lRes.add(p.val);
                if (p.left!=null){
                    queue.offer(p.left);
                }
                if (p.right!=null){
                    queue.offer(p.right);
                }
            }
            stack.push(lRes);
        }
        while (!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
