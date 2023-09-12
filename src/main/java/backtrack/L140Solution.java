package backtrack;

import java.util.*;

public class L140Solution {
    private List<String> res=new ArrayList<>();
    private Deque<String> storage=new ArrayDeque<>();
    private Set<String> set=new HashSet<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n=s.length();
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i = 1; i < n+1; i++) {
            for(String word : wordDict){
                int length=word.length();
                if (i-length>=0&&dp[i-length]&&word.equals(s.substring(i-length,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        for(String word : wordDict){
            set.add(word);
        }
        if (dp[n]){
            dfs(s,s.length(),dp);
        }
        return res;
    }
    private void dfs(String s,int end,boolean[] dp){
        if (end==0){
            res.add(String.join(" ",storage));
            return;
        }
        for (int i = end-1; i >=0 ; i--) {
            String s1=s.substring(i,end);
            if (dp[i]&&set.contains(s1)){
                storage.offerFirst(s1);
                dfs(s,i,dp);
                storage.removeFirst();
            }
        }
    }
}
