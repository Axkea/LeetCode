package dp;

public class S14Solution_1 {
    public int cuttingRope(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for (int i =3 ; i < n+1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i]=Math.max(dp[i],Math.max(Math.max(dp[i-j]*j,dp[j]*(i-j)),(i-j)*j));
            }
        }
        return dp[n];
    }
}
