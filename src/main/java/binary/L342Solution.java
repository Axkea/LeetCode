package binary;

public class L342Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0){
            return false;
        }
        return (n&(n-1))==0&&(n & 0b01010101010101010101010101010101) != 0;
    }
}
