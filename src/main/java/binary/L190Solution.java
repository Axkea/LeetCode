package binary;

public class L190Solution {
    public int reverseBits(int n) {
        int[] bits=new int[32];
        int move=1;
        bits[0]=move&n;
        for (int i = 1; i < 32; i++) {
            move<<=1;
            if((move&n)!=0){
                bits[i]=1;
            }else{
                bits[i]=0;
            }
        }
        int res=bits[0];
        for (int i = 1; i < 32; i++) {
            res<<=1;
            if(bits[i]==1){
                res^=1;
            }
        }
        return res;
    }
}
