package dp;

public class L416Solution {
    public boolean canPartition(int[] nums) {
        int length=nums.length;
        int sum=0;
        for (int i = 0; i < length; i++) {
            sum+=nums[i];
        }
        if(sum%2==0){
            sum=sum/2;
            boolean[][] dp=new boolean[length+1][sum+1];
            for (int i = 0; i < sum+1; i++) {
                dp[0][i]=false;
            }
            for (int i = 0; i < length+1; i++) {
                dp[i][0]=true;
            }
            for (int i = 1; i < length+1; i++) {
                for (int j = 1; j < sum+1; j++) {
                    if(j<nums[i-1]){
                        dp[i][j]=dp[i-1][j];
                    }else{
                        dp[i][j]=dp[i-1][j-nums[i-1]]||dp[i-1][j];
                    }
                }
            }
            return dp[length][sum];
        }
        return false;
    }
}
