package dp;

public class L5Solution {
    public String longestPalindrome(String s) {
        int length=s.length();
        boolean[][] dp=new boolean[length][length];
        int count=0,left=0,right=0;
        for(int i=length-1;i>=0;i--){
            for(int j=i;j<length;j++){
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j]=j-i<=2||dp[i+1][j-1];
                }
                if(dp[i][j]&&(j-i)>count){
                    left=i;right=j;
                    count=j-i;
                }
            }
        }
        return s.substring(left,right+1);
    }
}