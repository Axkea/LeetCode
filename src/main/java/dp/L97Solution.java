package dp;

public class L97Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m=s1.length(),n=s2.length(),k=s3.length();
        if (m+n!=k){
            return false;
        }
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for (int i = 0; i < m+1; i++) {
            for (int j = 0; j < n+1; j++) {
                int index=i+j-1;
                if (i>0){
                    dp[i][j]=dp[i][j]||(dp[i-1][j]&&s1.charAt(i-1)==s3.charAt(index));
                }
                if (j>0){
                    dp[i][j]=dp[i][j]||(dp[i][j-1]&&s2.charAt(j-1)==s3.charAt(index));
                }
            }
        }
        return dp[m][n];
    }
}
