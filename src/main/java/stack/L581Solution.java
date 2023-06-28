package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L581Solution {
    public int findUnsortedSubarray(int[] nums) {
        Deque<Integer> stack=new LinkedList<>();
        int n=nums.length;
        int left=n,right=-1;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty()&&nums[i]<nums[stack.peek()]){
                left=Math.min(left,stack.pop());
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty()&&nums[i]>nums[stack.peek()]){
                right=Math.max(right,stack.pop());
            }
            stack.push(i);
        }
        return left<right?right-left+1:0;
    }
}
