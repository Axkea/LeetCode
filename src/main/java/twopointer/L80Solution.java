package twopointer;

public class L80Solution {
    public int removeDuplicates(int[] nums) {
        int res=0;
        int count=1,now=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (now==nums[i]){
                count++;
                if (count>2){
                    res++;
                }
                nums[i-res]=nums[i];
            }else{
                now=nums[i];
                count=1;
                nums[i-res]=nums[i];
            }
        }
        return nums.length-res;
    }
}
