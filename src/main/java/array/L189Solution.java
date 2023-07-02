package array;

public class L189Solution {
    public void rotate(int[] nums, int k) {
        int length=nums.length;
        if(k>=length){
            k=k%length;
        }
        reverse(nums,0,length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,length-1);
    }
    private void reverse(int[] nums,int start,int end){
        int length=end-start+1;
        for (int i = 0; i < length>>1; i++) {
            int temp=nums[start+i];
            nums[start+i]=nums[end-i];
            nums[end-i]=temp;
        }
    }
}
