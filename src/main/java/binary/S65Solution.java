package binary;

public class S65Solution {
    public int add(int a, int b) {
        int move=1;
        int res=0;
        while(move!=0){
            move=a&b;
            res=a^b;
            a=move<<1;
            b=res;
        }
        return res;
    }
}
