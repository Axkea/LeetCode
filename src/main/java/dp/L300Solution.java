package dp;

import java.util.Arrays;

public class L300Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length,max=1,maxx=1;
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i < n; i++) {
            max=1;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i]>nums[j]){
                    max=Math.max(dp[j]+1,max);
                }
            }
            dp[i]=max;
            maxx=Math.max(maxx,dp[i]);
        }
        return maxx;
    }
}
