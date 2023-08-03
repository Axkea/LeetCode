package other;

public class L73Solution {
    public void setZeroes(int[][] matrix) {
        int[] cols=new int[matrix.length];
        int[] rows=new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j]==0){
                    cols[i]=1;
                    rows[j]=1;
                }
            }
        }
        for (int i = 0; i < cols.length; i++) {
            if (cols[i]==1){
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[i][j]=0;
                }
            }
        }
        for (int i = 0; i < rows.length; i++) {
            if (rows[i]==1){
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i]=0;
                }
            }
        }
    }
}
