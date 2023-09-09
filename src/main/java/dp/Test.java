package dp;


import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new L87Solution().isScramble("great", "rgeat"));
        testL131();
    }

    private static void testL115(){
        System.out.println(new L115Solution().numDistinct("bbbit", "bit"));
    }
    private static void testL131(){
        System.out.println(new L131Solution().partition("abbab"));
    }
}
