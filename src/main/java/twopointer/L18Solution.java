package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L18Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for (int i = 0; i <n-3 ; i++) {
            if (i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if ((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if ((long)nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target){
                continue;
            }
            for (int j = i+1; j <n-2 ; j++) {
                if (j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if ((long)nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if ((long)nums[i]+nums[j]+nums[n-2]+nums[n-1]<target){
                    continue;
                }
                int k=j+1,m=n-1;
                while(k<m){
                    long sum=nums[i]+nums[j]+nums[k]+nums[m];
                    if (sum==target){
                        List<Integer> ilist=new ArrayList<>();
                        ilist.add(nums[i]);
                        ilist.add(nums[j]);
                        ilist.add(nums[k]);
                        ilist.add(nums[m]);
                        res.add(ilist);
                        while (k<m&&nums[k+1]==nums[k]){
                            k++;
                        }
                        k++;
                        while(k<m&&nums[m-1]==nums[m]){
                            m--;
                        }
                        m--;
                    }else if (sum<target){
                        k++;
                    }else{
                        m--;
                    }

                }
            }
        }
        return res;
    }
}
