package dp;

public class Packge01_2 {
    public int maxValue(int weight,int number,int[] weights,int[] values){
        int[] dp=new int[weight+1];
        for (int i = 0; i < number; i++) {
            for (int j = weight; j >=weights[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weights[i]]+values[i]);
            }
        }
        return dp[weight];
    }
}
