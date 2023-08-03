package twopointer;


import linkedlist.ListNode;
import linkedlist.S26Solution2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int[] data={3,2,1};
//        new L31Solution().nextPermutation(data);
//        System.out.println(Arrays.toString(data));
//        int[][] intervals={{1,3},{6,9}};
//        int[] newInterval={2,5};
//        System.out.println(Arrays.toString(new L57Solution().insert(intervals, newInterval)));
        int[] data={1,1,1,2,2,3};
        System.out.println(new L80Solution().removeDuplicates(data));
    }
}
