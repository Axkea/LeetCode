package dp;

import java.util.List;

public class L139Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i = 0; i <= n; i++) {
            for(String word:wordDict){
                int length=word.length();
                if(i-length>=0&&word.equals(s.substring(i-length,i))){
                    dp[i]=dp[i]||dp[i-length];
                }
            }
        }
        return dp[n];
    }
}
