package exam.youka;

/**
 * @Author Axkea
 * @Date 2023/11/1/001 19:22
 * @Description
 */
public class Problem1_20231101 {
    public boolean checkBit (int num, int bit) {
        // write code here
        for (int i = 0; i < bit-1; i++) {
            num>>=1;
        }
        return (num&1)==1;
    }
}
