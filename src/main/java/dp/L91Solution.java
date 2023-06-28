package dp;

public class L91Solution {
    public int numDecodings(String s) {
        int length=s.length(),num;
        int[] dp=new int[length+1];
        dp[0]=1;dp[1]=s.charAt(0)=='0'?0:1;
        for (int i = 2; i < length+1; i++) {
            if(s.charAt(i-1)!='0'){
                dp[i]+=dp[i-1];
            }
            num=(s.charAt(i-1)-'0')+(s.charAt(i-2)-'0')*10;
            if(num>10&&num<27){
                dp[i]+=dp[i-2];
            }
        }
        return dp[length];
    }
}
