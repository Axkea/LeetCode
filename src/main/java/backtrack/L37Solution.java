package backtrack;

import java.util.ArrayList;
import java.util.List;

public class L37Solution {
    private boolean[][] rows=new boolean[9][9];
    private boolean[][] cols=new boolean[9][9];
    private boolean[][][] subBoard=new boolean[3][3][9];
    private boolean valid;
    private List<int[]> list=new ArrayList<>();
    public void solveSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c=board[i][j];
                if (c=='.'){
                    list.add(new int[]{i,j});
                }else{
                    int index=c-'0'-1;
                    rows[i][index]=cols[j][index]=subBoard[i/3][j/3][index]=true;
                }
            }
        }
        dfs(board,0);
    }
    private void dfs(char[][] board,int pos){
        if (pos==list.size()){
            valid=true;
            return;
        }
        int[] ints = list.get(pos);
        int x=ints[0],y=ints[1];
        for (int i = 0; i < 9&&!valid; i++) {
            if (!rows[x][i]&&!cols[y][i]&&!subBoard[x/3][y/3][i]){
                rows[x][i]=cols[y][i]=subBoard[x/3][y/3][i]=true;
                board[x][y]=(char)(i+'0'+1);
                dfs(board,pos+1);
                rows[x][i]=cols[y][i]=subBoard[x/3][y/3][i]=false;
            }
        }
    }
}
