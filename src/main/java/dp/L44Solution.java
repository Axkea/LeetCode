package dp;

public class L44Solution {
    public boolean isMatch(String s, String p) {
        int pl=p.length(),sl=s.length();
        if(pl==0&&sl!=0){
            return false;
        }
        boolean[][] dp=new boolean[sl+1][pl+1];
        dp[0][0]=true;
        for (int i = 1; i <= pl&&dp[0][i-1]; i++) {
            dp[0][i]=p.charAt(i-1)=='*';
        }
        for (int i = 1; i < sl+1; i++) {
            for (int j = 1; j < pl+1; j++) {
                char sc=s.charAt(i-1);
                char pc=p.charAt(j-1);
                if(pc==sc||pc=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(pc=='*'){
                    dp[i][j]=dp[i-1][j]||dp[i][j-1];
                }
            }
        }
        return dp[sl][pl];
    }
}
