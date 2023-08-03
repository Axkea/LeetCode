package math;

public class L66Solution {
    public int[] plusOne(int[] digits) {
        int count=1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if (digits[i]+count==10){
                digits[i]=0;
            }else{
                digits[i]+=count;
                count=0;
            }
        }
        if (count==1){
            int[] res=new int[digits.length+1];
            res[0]=1;
            for (int i = 1; i < res.length; i++) {
                res[i]=digits[i-1];
            }
            return res;
        }
        return digits;
    }
}
