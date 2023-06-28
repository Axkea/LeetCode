package dp;

public class S46Solution {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int n=s.length();
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            if(s.charAt(i-2)=='1'||(s.charAt(i-2)=='2'&&s.charAt(i-1)>='0'&&s.charAt(i-1)<='5')){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n];
    }
}
