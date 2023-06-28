package split_merge;

public class S51Solution {
    public int reversePairs(int[] nums) {
        int n=nums.length;
        if(n<2){
            return 0;
        }
        int[] temp=new int[n];
        return partition(nums,0,n-1,temp);
    }
    private int partition(int[] nums,int left,int right,int[] temp){
        if(left==right){
            return 0;
        }
        int mid=left+(right-left)/2;
        int leftCount=partition(nums,left,mid,temp);
        int rightCount=partition(nums,mid+1,right,temp);
        if(nums[mid]<=nums[mid+1]){
            return leftCount+rightCount;
        }
        int i = mergeAndCount(nums, left, mid, right, temp);
        return i+leftCount+rightCount;
    }
    private int  mergeAndCount(int[] nums,int left,int mid,int right,int[] temp){
        int _left=left,_right=mid+1,count=0;
        for (int i = left; i <=right; i++) {
            if(_left==mid+1){
                temp[i]=nums[_right++];
            }else if(_right==right+1){
                temp[i]=nums[_left++];
            }else if(nums[_left]<=nums[_right]){
                temp[i]=nums[_left++];
            }else{
                temp[i]=nums[_right++];
                count+=mid-_left+1;
            }
        }
        for (int i = left; i <=right; i++) {
            nums[i]=temp[i];
        }
        return count;
    }
}
