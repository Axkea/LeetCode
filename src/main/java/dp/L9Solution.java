package dp;

public class L9Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j <n ; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=(j-i)<=2||dp[i+1][j-1];
                }
            }
        }
        return dp[0][n-1];
    }
}
