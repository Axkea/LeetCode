package other;

public class L48Solution {
    public void rotate(int[][] matrix) {
        int x= matrix.length,y=matrix[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = i+1; j < y; j++) {
                swap(matrix,i,j,j,i);
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y/2; j++) {
                swap(matrix,i,j,i,y-1-j);
            }
        }
    }
    private void swap(int[][] matrix,int x1,int y1,int x2,int y2){
        int tmp=matrix[x1][y1];
        matrix[x1][y1]=matrix[x2][y2];
        matrix[x2][y2]=tmp;
    }
}
