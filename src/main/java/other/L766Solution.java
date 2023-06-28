package other;

public class L766Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        //验证第一行
        int y=matrix.length,x=matrix[0].length;
        for (int i = 0; i < x; i++) {
            if(!verification(x-1,y-1,matrix,i,0)){
                return false;
            }
        }
        for (int i = 0; i < y; i++) {
            if(!verification(x-1,y-1,matrix,0,i)){
                return false;
            }
        }
        return true;
    }
    private boolean verification(int x,int y,int[][] matrix,int start_x,int start_y){
        int maxStep=Math.min(y-start_y,x-start_x);
        int cur=matrix[start_y][start_x];
        for (int i = 1; i <= maxStep; i++) {
            if(matrix[start_y+i][start_x+i]!=cur){
                return false;
            }
            cur=matrix[start_y+i][start_x+i];
        }
        return true;
    }
}
