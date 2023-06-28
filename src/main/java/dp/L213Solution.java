package dp;

public class L213Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        if(n==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rob(nums,1,n),rob(nums,0,n-1));
    }
    public int rob(int[] nums,int start,int end){
        int[] dp=new int[end-start];
        for (int i = 0; i < end-start; i++) {
            if(i==0){
                dp[i]=nums[start];
                continue;
            }
            if(i==1){
                dp[i]=Math.max(nums[start],nums[start+1]);
                continue;
            }
            dp[i]=Math.max(dp[i-2]+nums[start+i],dp[i-1]);
        }
        return dp[end-start-1];
    }
}
