package dp;

public class L55Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            if(i<=max){
                max=Math.max(max,nums[i]+i);
            }
        }
        return max>=n-1;
    }
}
