package exam.shenxinfu;

import java.util.Scanner;

public class Problem2_20231017 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s=in.nextLine(),p=in.nextLine();
        int sl=s.length(),pl=p.length();
        boolean[][] dp=new boolean[sl+1][pl+1];
        dp[0][0]=true;
        for (int i = 0; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if (matches(s,p,i,j-1)){
                        dp[i][j]=dp[i][j]||dp[i-1][j];
                    }
                }else{
                    if (matches(s,p,i,j)){
                        dp[i][j]=dp[i-1][j-1];
                    }
                }
            }
        }
        if (dp[sl][pl]){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
    public static boolean matches(String s,String p,int i,int j){
        if (i==0){
            return false;
        }
        if (p.charAt(j-1)=='.'){
            return true;
        }
        return s.charAt(i-1)==p.charAt(j-1);
    }
}
