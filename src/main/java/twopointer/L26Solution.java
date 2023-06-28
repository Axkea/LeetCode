package twopointer;

import java.util.Arrays;

public class L26Solution {
    public int removeDuplicates(int[] nums) {
        int res=1,cur=nums[0],n=nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i]==cur){
                continue;
            }
            cur=nums[i];
            nums[res]=cur;
            res++;
        }
        System.out.println(Arrays.toString(nums));
        return res;
    }
}
