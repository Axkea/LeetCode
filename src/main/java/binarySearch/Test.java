package binarySearch;

import dp.L1187Solution;

import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
    public static void main(String[] args) {
        int[] arr1={1,5,3,6,7};
        int[] arr2={1,3,2,4};
        System.out.println(new L1187Solution().makeArrayIncreasing(arr1, arr2));
    }
}
