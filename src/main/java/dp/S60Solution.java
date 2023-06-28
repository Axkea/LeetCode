package dp;

public class S60Solution {
    public double[] dicesProbability(int n) {
        double[] pre={1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        for (int i = 1; i < n; i++) {
            double[] dp=new double[5*(i+1)+1];
            for (int j = 0; j < 5*(i)+1; j++) {
                for (int k = 0; k < 6; k++) {
                    dp[j+k]+=pre[j]*1/6d;
                }
            }
            pre=dp;
        }
        return pre;
    }
}
