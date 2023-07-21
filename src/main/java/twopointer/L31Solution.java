package twopointer;

public class L31Solution {
    public void nextPermutation(int[] nums) {
        int i=-1;int k=0;
        int n=nums.length;
        for (int j = n-1; j >0 ; j--) {
            if (nums[j-1]<nums[j]){
                i=j-1;
                break;
            }
        }
        if (i!=-1){
            for (int j = n-1; j >i ; j--) {
                if (nums[j]>nums[i]){
                    k=j;
                    break;
                }
            }
            int tmp=nums[i];
            nums[i]=nums[k];
            nums[k]=tmp;
        }
        reverse(nums,i+1);
    }
    private void reverse(int[] nums,int start){
        int n=nums.length;
        for (int i = start; i <start+(n-start+1)/2 ; i++) {
            int tmp=nums[i];
            nums[i]=nums[n-1+start-i];
            nums[n-1+start-i]=tmp;
        }
    }
}
