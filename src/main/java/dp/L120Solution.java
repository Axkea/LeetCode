package dp;

import java.util.List;

public class L120Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length=triangle.size();
        int[][] dp=new int[length][length];
        for (int i = length-1; i >=0 ; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if(i==length-1){
                    dp[i][j]=triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i+1][j+1])+triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }
}
