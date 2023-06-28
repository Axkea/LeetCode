package twopointer;

public class S8Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int begin=0,end=0,sum=0,res=Integer.MAX_VALUE;
        for (; end <nums.length ; end++) {
            sum+=nums[end];
            while(sum>=target){
                res=Math.min(res,end-begin+1);
                sum-=nums[begin];
                begin++;
            }
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
