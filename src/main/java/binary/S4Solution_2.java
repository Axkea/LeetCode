package binary;

public class S4Solution_2 {
    public int singleNumber(int[] nums) {
        int result=0;
        int[] res=new int[32];
        for (int num:nums){
            for (int i = 0; i < 32; i++) {
                res[i]+=(num>>i)&1;
            }
        }
        int move=1;
        for (int i = 0; i <32; i++) {
            if(res[i]%3!=0){
                result=result^move;
            }
            move=move<<1;
        }
        
        return result;
    }
}
