package twopointer;


import linkedlist.ListNode;
import linkedlist.S26Solution2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        int[] data={3,2,1};
        new L31Solution().nextPermutation(data);
        System.out.println(Arrays.toString(data));
    }
}
