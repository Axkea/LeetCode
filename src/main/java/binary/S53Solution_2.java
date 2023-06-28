package binary;

public class S53Solution_2 {
    public int missingNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res=res^(i+1)^nums[i];
        }
        return res;
    }
}
