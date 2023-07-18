package string;

public class Test {
    public static void main(String[] args) {
//        L8Solution solution=new L8Solution();
//        System.out.println(solution.myAtoi(" -42"));
//        String[] data={"flower","flow","flight"};
//        System.out.println(new L14Solution().longestCommonPrefix(data));
        KMP kmp=new KMP("aabaaf");
        kmp.search("asd");
    }
}
