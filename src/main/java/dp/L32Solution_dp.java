package dp;

public class L32Solution_dp {
    public int longestValidParentheses(String s) {
        int max=0;
        int n=s.length();
        int[] dp=new int[n];
        for (int i = 1; i < n; i++) {
            if (i>=2&&s.charAt(i)==')'&&s.charAt(i-1)=='('){
                dp[i]=dp[i-2];
            }
            if (i-dp[i-1]-1>=0&&s.charAt(i)==')'&&s.charAt(i-dp[i-1]-1)=='('){
                dp[i]=dp[i-1]+2+((i-dp[i-1]-1>0)?dp[i-dp[i-1]-2]:0);
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
