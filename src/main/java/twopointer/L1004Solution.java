package twopointer;

//使用（非固定大小）滑动窗口
public class L1004Solution {
    public int longestOnes(int[] nums, int k) {
        int res=0,left=0,right=0,n=nums.length,count_zero=0;
        while(right<n){
            if(nums[right]==0){
                count_zero++;
            }
            while(count_zero>k&&left<=right){
                if(nums[left]==0){
                    count_zero--;
                }
                left++;
            }
            res=Math.max(res,right-left+1);
            right++;
        }
        return res;
    }
}
