package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L199Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode cur=root;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            res.add(queue.get(size-1).val);
            for (int i = 0; i < size; i++) {
                cur=queue.pop();
                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }
}
