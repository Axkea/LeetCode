package dp;

public class S42Solution {
    public int maxSubArray(int[] num) {
        int length=num.length,max=num[0];
        int[] dp=new int[length];
        dp[0]=num[0];
        for (int i = 1; i < length; i++) {
            dp[i]=Math.max(num[i],num[i]+dp[i-1]);
            max=Math.max(dp[i],max);
        }
        return max;
    }
    public int maxSubArray1(int[] num) {
        int length=num.length,res=num[0],right=0,left0=0;
        int[] dp=new int[length];
        dp[0]=num[0];
        for (int i = 1; i < length; i++) {

            if(dp[i-1]>=0){
                dp[i]=num[i]+dp[i-1];
                if(res<dp[i]){
                    res=dp[i];
                    right=i;
                }
            }else{
                dp[i]=num[i];
                if(res<dp[i]){
                    res=dp[i];
                    left0=i;
                    right=i;
                }
            }
        }
        System.out.println(left0+"  "+right);
        return res;
    }
}
