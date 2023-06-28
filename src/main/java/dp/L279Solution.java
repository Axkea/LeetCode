package dp;

import java.util.Arrays;

public class L279Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        double ceil = Math.ceil(Math.sqrt(n));
        for (int i = 1; i <= ceil; i++) {
            for (int j = i*i; j <n+1 ; j++) {
                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
            }
        }
        return dp[n];
    }
}
