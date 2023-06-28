package array;

public class S53Solution2 {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        long res=(1+n)*n/2;
        long count=0;
        for (int i = 0; i < n; i++) {
            count+=nums[i];
        }
        return (int)(res-count);
    }
}
