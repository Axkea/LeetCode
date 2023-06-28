package binary;

public class L540Solution {
    public int singleNonDuplicate(int[] nums) {
        int res=nums[0];
        for (int i = 1; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
}
