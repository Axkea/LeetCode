package dp;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new L87Solution().isScramble("great", "rgeat"));
//        testL131();
//        Scanner in=new Scanner(System.in);
//        String s=in.next();
//        List<String> wordDict=new ArrayList<>();
//        while (in.hasNextLine()){
//            wordDict.add(in.nextLine());
//        }
//        int n=s.length();
//        boolean[] dp=new boolean[n+1];
//        dp[0]=true;
//        for (int i = 0; i <= n; i++) {
//            for(String word:wordDict){
//                int length=word.length();
//                if(i-length>=0&&word.equals(s.substring(i-length,i))){
//                    dp[i]=dp[i]||dp[i-length];
//                }
//            }
//        }
//        System.out.println(dp[n]);
//        maxWindows();
        System.out.println(Calendar.getInstance().getTime());
    }


    private static void testL115(){
        System.out.println(new L115Solution().numDistinct("bbbit", "bit"));
    }
    private static void testL131(){
        System.out.println(new L131Solution().partition("abbab"));
    }
    public static void maxWindows(){
        Scanner in =new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int[] arr=new int[s.length];
        for (int i = 0; i < s.length; i++) {
            arr[i]=Integer.parseInt(s[i]);
        }
        int k=in.nextInt();
//        int[] arr=new int[]{1,3,-1,-3,5,3,6,7};
//        int k=3;
        int now=0;
        int left=0,right=k-1;
        for (int i = left; i <=right ; i++) {
            now+=arr[i];
        }
        int max=0;
        while (right!=arr.length-1){
            right++;
            now-=arr[left];
            left++;
            now+=arr[right];
            max=Math.max(max,now);
        }
        System.out.println(max);
    }
}
