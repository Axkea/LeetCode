package dp;

public class L746Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length=cost.length;
        int[] dp=new int[length+1];
        dp[0]=0;dp[1]=0;
        for (int i = 2; i < length+1; i++) {
            dp[i]=Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[length];
    }
}
