package dp;

public class L221Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0,length1=matrix.length,length2=matrix[0].length;
        int[][] dp=new int[length1+1][length2+1];
        for (int i = 1; i < length1+1; i++) {
            for (int j = 1; j < length2+1; j++) {
                if(matrix[i-1][j-1]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
