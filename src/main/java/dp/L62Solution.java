package dp;

public class L62Solution {
    public int uniquePaths(int m, int n) {
        int[] dp=new int[n+1];
        for (int i = 0; i < n+1; i++) {
            dp[i]=1;
        }
        for(int i=1;i<m;i++){
            for (int j = 0; j < n; j++) {
                dp[j+1]=dp[j]+dp[j+1];
            }
        }
        return dp[n-1];
    }
}
