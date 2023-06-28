package dp;

public class Packge01 {
    public int maxValue(int weight,int number,int[] weights,int[] values){
        int[][] dp=new int[number+1][weight+1];
        for (int i = 0; i < number+1; i++) {
            dp[i][0]=0;
        }
        for (int i = 0; i < weight+1; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i < number+1; i++) {
            for (int j = 1; j < weight+1; j++) {
                if(weights[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[number][weight];
    }
    //review
    public int maxValue(int weight,int[] weights,int[] values){
        int num=weights.length;
        int[][] dp=new int[num+1][weight+1];
        for (int i = 0; i < num+1; i++) {
            dp[0][i]=0;
            dp[i][0]=0;
        }
        for (int i = 1; i < num+1; i++) {
            for (int j = 1; j < weight; j++) {
                if(weights[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+values[i-1]);
                }
            }
        }
        return dp[num][weight];
    }
}
