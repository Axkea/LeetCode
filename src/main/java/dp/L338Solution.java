package dp;

public class L338Solution {
    public int[] countBits(int n) {
        int[] dp=new int[n+1];
        dp[0]=0;
        int hbit=0;
        for (int i = 1; i < n+1; i++) {
            if((i&(i-1))==0){
                hbit=i;
            }
            dp[i]=dp[i-hbit]+1;
        }
        return dp;
    }
}
