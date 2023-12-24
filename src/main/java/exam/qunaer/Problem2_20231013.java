package exam.qunaer;

public class Problem2_20231013 {
    public int minPath (int[][] paths) {
        // write code here
        int m=paths.length;
        if (m==0){
            return 0;
        }
        int n=paths[0].length;
        int[][] minValue=new int[m][n];
        minValue[0][0]=paths[0][0];
        for (int i = 1; i < m; i++) {
            minValue[i][0]=minValue[i-1][0]+paths[i][0];
        }
        for (int i = 1; i < n; i++) {
            minValue[0][i]=minValue[0][i-1]+paths[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                minValue[i][j]=Math.min(minValue[i][j-1],minValue[i-1][j])+paths[i][j];
            }
        }
        return minValue[m-1][n-1];
    }
}
