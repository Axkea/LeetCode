package array;

import java.util.Arrays;

public class S53Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int count=nums.length/2;
        int res=0;
        if(n%2==0){
            int left=-1,right=n;
            for (int i = 1; i <=count; i++) {
                if(nums[++left]==target){
                    res++;
                }
                if(nums[--right]==target){
                    res++;
                }
            }
        }else{
            if(nums[count]==target){
                res++;
            }
            int left=-1,right=n;
            for (int i = 1; i <=count; i++) {
                if(nums[++left]==target){
                    res++;
                }
                if(nums[--right]==target){
                    res++;
                }
            }
        }
        return res;
    }
}
