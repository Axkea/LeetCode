package backtrack;

public class S12Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(backTrace(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean backTrace(char[][] board,String word,int x,int y,int index){
        if(x<0||x>=board.length||y<0||y>=board[0].length||index>=word.length()||word.charAt(index)!=board[x][y]){
            return false;
        }
        if(index==word.length()-1){
            return true;
        }
        char temp=board[x][y];
        board[x][y]='.';
        boolean flag=backTrace(board,word,x-1,y,index+1)||backTrace(board,word,x+1,y,index+1)||
                backTrace(board,word,x,y-1,index+1)||backTrace(board,word,x,y+1,index+1);
        board[x][y]=temp;
        return flag;
    }
}
