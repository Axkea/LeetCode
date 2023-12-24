package array;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        L189Solution solution=new L189Solution();
//        int[] data={3,30,34,5,9};
//        solution.rotate(data,12);
//        System.out.println(Arrays.toString(data));
        int[] data={3,30,34,5,9,12};
//        Sort.quickSort(data,0,4);
//        System.out.println(Arrays.toString(data));
        SortREW.quickSort2(data,0,5);
        System.out.println(Arrays.toString(data));
    }
}
