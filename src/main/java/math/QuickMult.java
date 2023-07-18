package math;

public class QuickMult {
    public double multiplication(double base, int n){
        int sign=1;
        if (n<0){
            sign=-1;
            n=-n;
        }
        double res=0,m=base;
        while(n!=0){
            if ((n&1)==1){
                res+=base;
            }
            base+=base;
            n>>>=1;
        }
        return res;
    }
}
