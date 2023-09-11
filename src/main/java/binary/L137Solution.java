package binary;

public class L137Solution {
    public int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < 32; i++) {
            int total=0;
            for (int j = 0; j < nums.length; j++) {
                total+=(nums[j]>>i)&1;
            }
            if (total%3!=0){
                res|=(1<<i);
            }
        }
        return res;
    }
}
