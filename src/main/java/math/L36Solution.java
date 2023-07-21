package math;

public class L36Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows=new int[9][9];
        int[][] cols=new int[9][9];
        int[][][] subBoard=new int[3][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c=board[i][j];
                if (c!='.'){
                    int index=c-'0'-1;
                    rows[i][index]++;
                    cols[j][index]++;
                    subBoard[i/3][j/3][index]++;
                    if (rows[i][index]>1||cols[j][index]>1||subBoard[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
