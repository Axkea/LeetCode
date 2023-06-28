package dp;

public class L152Solution {
    public int maxProduct(int[] nums) {
        int n=nums.length;
        int maxValue=nums[0];
        int minValue=nums[0];
        int ans=nums[0];
        for (int i = 1; i < n; i++) {
            int max=maxValue,min=minValue;
            maxValue=Math.max(min*nums[i],Math.max(max*nums[i],nums[i]));
            minValue=Math.min(max*nums[i],Math.min(min*nums[i],nums[i]));
            ans=Math.max(maxValue,ans);
        }
        return ans;
    }
}
