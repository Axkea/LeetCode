package binarySearch;

public class L34Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1,second=-1,n=nums.length;
        if(nums.length==0||nums==null){
            return new int[]{first,second};
        }
        int low=0,high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(target==nums[mid]){
                high=mid;
            }
            if(target>nums[mid]){
                low=mid+1;
            }else if(target<nums[mid]){
                high=mid-1;
            }
        }
        if(nums[low]!=target){
            return new int[]{first,second};
        }
        first=low;
        second=first;
        if(first==n-1){
            return new int[]{first,second};
        }
        for (int i = first; i <n-1 ; i++) {
            if(nums[i+1]==target){
                second=i+1;
            }
        }
        return new int[]{first,second};
    }
}
