package dp;

public class L53Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        int max=dp[0];
        for (int i = 1; i < n; i++) {
            dp[i]=Math.max(dp[i-1],0)+nums[i];
            max=Math.max(max,dp[i]);
        }
        return  max;
    }
}
