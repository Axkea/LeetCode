package binary;

public class L693Solution {
    public boolean hasAlternatingBits(int n) {
        int tmp=n^(n>>1);
        return (tmp&(tmp+1))==0;
    }
}
