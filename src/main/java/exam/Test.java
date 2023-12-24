package exam;

import exam.nenglian.Problem2_20231014;
import exam.qunaer.Problem1_20231013;
import exam.qunaer.*;
import exam.shenxinfu.Problem4_20231017;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new Problem1_20231013().maxSubsequenceAndReverse("abcde", "ace"));
//        testP2();
//        nengTestp2();
        System.out.println(new Problem4_20231017().substr("DKAFWADCBEIL","BCA"));
    }
    public static void testP2(){
        int[][] path=new int[][]{{1,2,1},{1,3,4},{5,7,8}};
        System.out.println(new Problem2_20231013().minPath(path));
    }
    public static void testP3(){
        System.out.println(new Problem3_20231013().percent(10, 17, 21));
    }
    public static void nengTestp2(){
        String[] board={"XYZE","SFZS","XDEE"};
        System.out.println(new Problem2_20231014().exist(board, "XYZZED"));
    }
}
