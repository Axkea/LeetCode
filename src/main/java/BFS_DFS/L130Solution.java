package BFS_DFS;

public class L130Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for (int i=0;i<m;i++){
            if(board[i][0]=='O'){
                backTrace(board,i,0);
            }
            if(board[i][n-1]=='O'){
                backTrace(board,i,n-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if(board[0][i]=='O'){
                backTrace(board,0,i);
            }
            if(board[m-1][i]=='O'){
                backTrace(board,m-1,i);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }
            }
        }
    }
    private void backTrace(char[][] board,int x,int y){
        if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]!='O'){
            return;
        }
        board[x][y]='A';
        backTrace(board,x-1,y);
        backTrace(board,x+1,y);
        backTrace(board,x,y-1);
        backTrace(board,x,y+1);
    }
}
