package dp;

public class L1043Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        //计算前k个的最大值
        int max=0;
        for (int i = 0; i < k; i++) {
            max=Math.max(max,arr[i]);
            dp[i]=max*(i+1);
        }
        //计算k-n之间的最大值
        for (int i = k; i <n ; i++) {
            int max1=0;
            for (int j = i; j >i-k ; j--) {
                max1=Math.max(max1,arr[j]);
                dp[i]=Math.max(dp[j-1]+max1*(i-j+1),dp[i]);
            }
        }
        return dp[n-1];
    }
}
