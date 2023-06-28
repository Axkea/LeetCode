package dp;

public class L45Solution {
    public int jump(int[] nums) {
        int count=1,n=nums.length,i=0;
        if (n==1){
            return 0;
        }
        while(true){
            if (i+nums[i]>=n-1){
                break;
            }
            int max=0,index=0;
            for (int j = i+nums[i]; j >i ; j--) {
                if (j+nums[j]>=max){
                    max=j+nums[j];
                    index=j;
                }

            }
            i=index;
            count++;
        }
        return count;
    }
}
