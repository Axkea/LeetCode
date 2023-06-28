package stack;

import java.util.Deque;
import java.util.LinkedList;

public class S33Solution {
    public boolean verifyPostorder(int[] postorder) {
        int n=postorder.length;
        Deque<Integer> stack=new LinkedList<>();
        int root=Integer.MAX_VALUE;
        for (int i = n-1; i >=0 ; i--) {
            if(postorder[i]>root){
                return false;
            }
            while(!stack.isEmpty()&&stack.peek()>postorder[i]){
                root=stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
