package dp;

public class L132Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)){
                    dp[i][j]=j-i<=2||dp[i+1][j-1];
                }
            }
        }
        int[] minCutNum=new int[n];
        for (int i = 0; i < n; i++) {
            if (dp[0][i]){
                minCutNum[i]=0;
            }else{
                minCutNum[i]=Integer.MAX_VALUE;
                for (int j = i-1; j >=0 ; j--) {
                    if (dp[j+1][i]){
                        minCutNum[i]=Math.min(minCutNum[i],minCutNum[j]+1);
                    }
                }
            }
        }
        return minCutNum[n-1];
    }
}
