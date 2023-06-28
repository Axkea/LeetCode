package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class S32Solution3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int count=0;
        while(queue.size()!=0){
            LinkedList<Integer> ress=new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode pop = queue.pop();
                if(count%2==0){
                    ress.add(pop.val);
                }else {
                    ress.push(pop.val);
                }
                if(pop.left!=null){
                    queue.add(pop.left);
                }
                if(pop.right!=null){
                    queue.add(pop.right);
                }
            }
            res.add(ress);
            count++;
        }
        return res;
    }
}
