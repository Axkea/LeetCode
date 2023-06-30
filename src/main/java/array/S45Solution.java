package array;

import java.util.Arrays;

public class S45Solution {
    public String minNumber(int[] nums) {
        String[] numString=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numString[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(numString,(a,b)->(a+b).compareTo(b+a));
        StringBuilder builder=new StringBuilder();
        for (String s:
             numString) {
            builder.append(s);
        }
        return builder.toString();
    }
}
