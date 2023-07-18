package math;

public class L50Solution {
    public double myPow(double x, int n) {
        int sign=1;
        if (n<0){
            sign=-1;
            n=-n;
        }
        double res=1;double m=x;
        while (n!=0){
            if ((n&1)==1){
                res*=m;
            }
            m*=m;
            n>>>=1;
        }
        return sign>=0?res:1/res;
    }
}
