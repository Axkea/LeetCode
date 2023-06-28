package dp;

public class SplitApple {
    public int solution(int m,int n){
        int[][] res=new int[m+1][n+1];
        for (int i = 1; i <m+1 ; i++) {
            res[i][1]=1;
        }
        for(int i=1;i<m+1;i++){
            for (int j = 2; j < n+1; j++) {
                if(i<j){
                    res[i][j]=res[i][i];
                }else{
                    res[i][j]=res[i-j][j]+res[i][j-1];
                }
            }
        }
        return res[m][n];
    }
}
