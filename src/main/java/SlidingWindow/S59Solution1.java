package SlidingWindow;

import java.util.LinkedList;

public class S59Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return null;
        }
        int length=nums.length;
        int[] res=new int[length-k+1];
        //单调队列
        LinkedList<Integer> ilist=new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while(!ilist.isEmpty()&&nums[i]>=nums[ilist.peek()]){
                ilist.pop();
            }
            ilist.push(i);
        }
        res[0]=nums[ilist.peekLast()];
        for (int i = k; i < length; i++) {
            while(!ilist.isEmpty()&&nums[i]>=nums[ilist.peek()]){
                ilist.pop();
            }
            ilist.push(i);
            while(i-k+1>ilist.peekLast()){
                ilist.removeLast();
            }
            res[i-k+1]=nums[ilist.peekLast()];
        }
        return res;
    }
}
