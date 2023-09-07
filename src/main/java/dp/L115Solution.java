package dp;

public class L115Solution {
    //给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 109 + 7 取模。

    //输入：s = "rabbbit", t = "rabbit"
    //输出：3
    public int numDistinct(String s, String t) {
        int n=s.length(),m=t.length();
        int[][] dp=new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            dp[i][m]=1;
        }
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0; j--) {
                if (s.charAt(i)==t.charAt(j)){
                    dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
                }else{
                    dp[i][j]=dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}
