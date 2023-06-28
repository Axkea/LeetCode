package dp;

public class L413Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n=nums.length;
        int temp=0,res=0;
        for (int i = 2; i < n; i++) {
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                temp=temp+1;
                res+=temp;
            }else{
                temp=0;
            }
        }
        return res;
    }
}
