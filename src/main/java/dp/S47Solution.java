package dp;

public class S47Solution {
    public int maxValue(int[][] grid) {
        int[] dp=new int[grid[0].length+1];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 1; j < grid[0].length+1; j++) {
                dp[j]=Math.max(dp[j-1],dp[j])+grid[i][j-1];
            }
        }
        return dp[grid[0].length];
    }
}
