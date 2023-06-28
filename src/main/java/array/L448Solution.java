package array;

import java.util.ArrayList;
import java.util.List;

public class L448Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> iList=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<0){
                nums[-nums[i]-1]=nums[-nums[i]-1]<0?nums[-nums[i]-1]:-nums[-nums[i]-1];
            }else{
                nums[nums[i]-1]=nums[nums[i]-1]<0?nums[nums[i]-1]:-nums[nums[i]-1];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                iList.add(i+1);
            }
        }
        return iList;
    }
}
