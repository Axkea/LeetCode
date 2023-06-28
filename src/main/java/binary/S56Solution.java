package binary;

public class S56Solution {
    public int[] singleNumbers(int[] nums) {
        int diff=0;
        for (int num:nums){
            diff^=num;
        }
        int move=1;
        for (int i = 1; i < 32; i++) {
            if((diff&move)!=0){
                break;
            }
            move<<=1;
        }
        int res1=0;
        int res2=0;
        for(int num:nums){
            if((num&move)==0){
                res1^=num;
            }else {
                res2^=num;
            }
        }
        return new int[]{res1,res2};
    }
}
