package twopointer;

import java.util.Arrays;

public class L16Solution {
    public int threeSumClosest(int[] nums, int target) {
        int best=100000,n=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int j=i+1,k=n-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if (sum==target){
                    return target;
                }
                if (Math.abs(sum-target)<Math.abs(best-target)){
                    best=sum;
                }
                if (sum>target){
                    int k0=k-1;
                    while (j<k0&&nums[k0]==nums[k]){
                        k0--;
                    }
                    k=k0;
                }else{
                    int j0=j+1;
                    while (j0<k&&nums[j0]==nums[j]){
                        j0++;
                    }
                    j=j0;
                }
            }
        }
        return best;
    }
}
