package array;

public class L27Solution {
    public int removeElement(int[] nums, int val) {
        int count=0,length=nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i]==val){
                count++;
            }else{
                nums[i-count]=nums[i];
            }
        }
        return length-count;
    }
}
