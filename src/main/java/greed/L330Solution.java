package greed;

public class L330Solution {
    public int minPatches(int[] nums, int n) {
        int count=0,i=0;
        long total=0;
        while(total<n){
            if(i<nums.length&&total>=nums[i]-1){
                total+=nums[i++];
            }else{
                total=total+(total+1);
                count++;
            }
        }
        return count;
    }
    public int minPatches2(int[] nums, int n) {
        long total=0;int index=0,res=0;
        while(total<n){
            if(index<nums.length&&total>=nums[index]-1){
                total=total+nums[index++];
            }else{
                total+=(total+1);
                res++;
            }
        }
        return res;
    }
}
