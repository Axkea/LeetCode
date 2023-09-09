package dp;

import java.util.ArrayList;
import java.util.List;

public class L131Solution {
    private List<List<String>> res=new ArrayList<>();
    private List<String> storage=new ArrayList<>();
    public List<List<String>> partition(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=j-i<=2||dp[i+1][j-1];
                }
            }
        }
        backTrack(0,s,dp);
        return res;
    }
    private void backTrack(int start,String s,boolean[][] dp){
        if (start==s.length()){
            res.add(new ArrayList<>(storage));
            return;
        }
        for (int i = start; i <s.length() ; i++) {
            if (dp[start][i]){
                storage.add(s.substring(start,i+1));
                backTrack(i+1,s,dp);
                storage.remove(storage.size()-1);
            }
        }
    }
}
