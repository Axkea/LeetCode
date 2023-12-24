package exam.nenglian;

import java.util.LinkedList;

public class Problem2_20231014 {
    private String[] board;
    private String word;
    private boolean[][] isUsed;
    public boolean exist (String[] board, String word) {
        // write code here
        this.board=board;
        this.word=word;
        int len=board.length;
        int sLen=board[0].length();
        isUsed=new boolean[len][sLen];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < sLen; j++) {
                if (board[i].charAt(j)==word.charAt(0)){
                    isUsed[i][j]=true;
                    boolean dfs = dfs(i, j,1);
                    if (dfs){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int x,int y,int index){
        if (index==word.length()){
            return true;
        }
        boolean upBool=false;
        boolean downBool=false;
        boolean leftBool=false;
        boolean rightBool=false;
        //up
        if (x>0&&!isUsed[x-1][y]&&(board[x-1].charAt(y)==word.charAt(index))){
            if (index==word.length()-1){
                upBool=true;
            }else{
                isUsed[x-1][y]=true;
                upBool=dfs(x-1,y,index+1);
                isUsed[x-1][y]=false;
            }
        }
        //down
        if (x<board.length-1&&!isUsed[x+1][y]&&(board[x+1].charAt(y)==word.charAt(index))){
            if (index==word.length()-1){
                downBool=true;
            }else{
                isUsed[x+1][y]=true;
                downBool=dfs(x+1,y,index+1);
                isUsed[x+1][y]=false;
            }
        }
        //left
        if (y>0&&!isUsed[x][y-1]&&(board[x].charAt(y-1)==word.charAt(index))){
            if (index==word.length()-1){
                leftBool=true;
            }else{
                isUsed[x][y-1]=true;
                leftBool=dfs(x,y-1,index+1);
                isUsed[x][y-1]=false;
            }
        }
        //right
        if (y<board[0].length()-1&&!isUsed[x][y+1]&&(board[x].charAt(y+1)==word.charAt(index))){
            if (index==word.length()-1){
                rightBool=true;
            }else{
                isUsed[x][y+1]=true;
                rightBool=dfs(x,y+1,index+1);
                isUsed[x][y+1]=false;
            }
        }
        return upBool||downBool||leftBool||rightBool;
    }
}
