package binary;

public class L476Solution {
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int mask = 1 << 30;
        while ((num & mask) == 0) {
            mask >>= 1;
        }
        mask = (mask << 1) - 1;
        return num ^ mask;
    }
}
