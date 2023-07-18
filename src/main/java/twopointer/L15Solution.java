package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L15Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        int n=nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            int target=-nums[i];
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            int third=n-1;
            for (int j = i+1; j < n-1; j++) {

                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                while (j<third&&nums[j]+nums[third]>target){
                    third--;
                }
                if (j==third){
                    break;
                }
                if (nums[j]+nums[third]==target){
                    List<Integer> ilist=new ArrayList<>();
                    ilist.add(nums[i]);
                    ilist.add(nums[j]);
                    ilist.add(nums[third]);
                    res.add(ilist);
                }
            }
        }
        return res;
    }
}
