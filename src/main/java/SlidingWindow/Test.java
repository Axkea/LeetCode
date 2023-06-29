package SlidingWindow;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        S59Solution1 solution1=new S59Solution1();
        int[] test={1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(solution1.maxSlidingWindow(test,3)));
    }
}
