package binarytree;

import java.util.ArrayList;
import java.util.List;

public class S54Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> ilist=new ArrayList<>();
        reverse(root,ilist,k);
        return ilist.get(k-1);
    }
    private void reverse(TreeNode node, List<Integer> integerList,int k){
        if(node==null||integerList.size()==k){
            return;
        }
        reverse(node.right,integerList,k);
        integerList.add(node.val);
        reverse(node.left,integerList,k);
    }

}
