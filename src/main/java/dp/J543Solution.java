package dp;

public class J543Solution {
    public int maxValue(int[][] grid){
        if(grid==null||grid.length==0){
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m+1][n+1];
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[m][n];
    }
}
