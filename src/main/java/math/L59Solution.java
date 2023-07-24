package math;

public class L59Solution {
    public int[][] generateMatrix(int n) {
        int[][] res=new int[n][n];
        int l=0,r=n-1,u=0,d=n-1;
        int count=1;
        while (true){
            for (int i = l; i <=r ; i++) {
                res[u][i]=count++;
            }
            u++;
            if (u>d){
                break;
            }
            for (int i = u; i <=d ; i++) {
                res[i][r]=count++;
            }
            r--;
            if (r<l){
                break;
            }
            for (int i = r; i >=l ; i--) {
                res[d][i]=count++;
            }
            d--;
            if (u>d){
                break;
            }
            for (int i = d; i >=u ; i--) {
                res[i][l]=count++;
            }
            l++;
            if (r<l){
                break;
            }
        }
        return res;
    }
}
