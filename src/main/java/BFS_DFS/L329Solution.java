package BFS_DFS;

public class L329Solution {
    private int[][] direction={{0,-1},{0,1},{-1,0},{1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int res=0;
        int row= matrix.length,col=matrix[0].length;
        int[][] dp=new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res=Math.max(res,dfs(i, j, matrix, dp));
            }
        }
        return res;
    }
    private int dfs(int row,int col,int[][] matrix,int[][] dp){
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        dp[row][col]++;
        for(int[] dire:direction){
            int newRow=row+dire[0],newCol=col+dire[1];
            if(newRow>=0&&newRow<matrix.length&&newCol>=0&&newCol<matrix[0].length&&matrix[newRow][newCol]>matrix[row][col]){
                dp[row][col]=Math.max(dp[row][col],dfs(newRow,newCol,matrix,dp)+1);
            }
        }
        return dp[row][col];
    }
}
