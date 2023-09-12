package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        String s="abc";
//        System.out.println(s.substring(2, 3));
        testL140();
    }

    private static void testL140(){
        String s="catsanddog";
        List<String> list=new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");
        System.out.println(new L140Solution().wordBreak(s, list));
    }
}

