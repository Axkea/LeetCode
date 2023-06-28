package dp;

public class S66Solution {
    public int[] constructArr(int[] a) {
        int n=a.length;
        int[] res=new int[n];
        if(n==0){
            return res;
        }
        int[] fp=new int[n];
        int[] bp=new int[n];
        fp[0]=1;
        bp[n-1]=1;
        for (int i = 1; i < n; i++) {
            fp[i]=a[i-1]*fp[i-1];
            bp[n-i-1]=a[n-i]*bp[n-i];
        }
        for (int i = 0; i < n; i++) {
            res[i]=fp[i]*bp[i];
        }
        return res;
    }
}
