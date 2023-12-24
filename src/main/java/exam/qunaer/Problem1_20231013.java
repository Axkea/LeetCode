package exam.qunaer;

public class Problem1_20231013 {
    public String maxSubsequenceAndReverse (String string1, String string2) {
        // write code here
        int n1=string1.length();
        int n2=string2.length();
        StringBuilder[][] dp=new StringBuilder[n1+1][n2+1];
        for (int i = 0; i < n1+1; i++) {
            dp[i][0]=new StringBuilder();
        }
        for (int i = 0; i < n2+1; i++) {
            dp[0][i]=new StringBuilder();
        }
        for (int i = 1; i < n1+1; i++) {
            for (int j = 1; j < n2+1; j++) {
                if (string1.charAt(i-1)== string2.charAt(j-1)){
                    dp[i][j]=new StringBuilder(dp[i-1][j-1].append(string1.charAt(i-1)));
                }else{
                    if (dp[i-1][j].length()>dp[i][j-1].length()){
                        dp[i][j]=new StringBuilder(dp[i-1][j]);
                    }else{
                        dp[i][j]=new StringBuilder(dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n1][n2].reverse().toString();
    }
}
