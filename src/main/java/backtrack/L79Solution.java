package backtrack;

public class L79Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length,n=board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(backTrace(board,word,0,i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backTrace(char[][] board, String word,int index,int x,int y){
        if(x>=board.length||x<0||y<0||y>=board[0].length||word.charAt(index)!=board[x][y]){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        char temp=board[x][y];
        board[x][y]='.';
        boolean flag=backTrace(board,word,index+1,x+1,y)||backTrace(board,word,index+1,x-1,y)||backTrace(board,word,index+1,x,y+1)||backTrace(board,word,index+1,x,y-1);
        board[x][y]=temp;
        return flag;
    }
}
