package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S32Solution2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(queue.size()!=0){
            List<Integer> ress=new ArrayList<>();
            for (int i=0;i<queue.size();i++){
                TreeNode pop = queue.pop();
                ress.add(pop.val);
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }
            res.add(ress);
        }
        return res;
    }
}
