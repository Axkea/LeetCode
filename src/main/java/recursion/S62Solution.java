package recursion;

public class S62Solution {
    private int recursion(int n,int m){
        if (n==1){
            return 0;
        }
        return (recursion(n-1,m)+m)%n;
    }
    public int lastRemaining(int n, int m) {
        return recursion(n,m);
    }
}
