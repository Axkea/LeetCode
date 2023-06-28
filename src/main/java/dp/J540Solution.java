package dp;

public class J540Solution {
    public int countSubstrings(String s){
        int n=s.length();int count=0;
        boolean[][] dp=new boolean[n][n];
        dp[0][0]=true;
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=(j-i<3||dp[i+1][j-1]);
                    if(dp[i][j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
