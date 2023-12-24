package exam.shuzmali;

import java.util.Scanner;

public class Problem3_20231023 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine();
        String p=in.nextLine();
        int ns=s.length(),np=p.length();
        boolean[][] dp=new boolean[ns+1][np+1];
        dp[0][0]=true;
        for (int i = 0; i < np; i++) {
            if (p.charAt(i)=='*'&&dp[0][i-1]){
                dp[0][i+1]=true;
            }
        }
        for (int i = 1; i <= ns ; i++) {
            for (int j = 1; j <=np ; j++) {
                if (p.charAt(j-1)==s.charAt(i-1)||p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    if (p.charAt(j-2)==s.charAt(i-1)||p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i-1][j];
                    }
                    dp[i][j]|=dp[i][j-2];
                }
            }
        }
        System.out.println(dp[ns][np]);
    }
}
