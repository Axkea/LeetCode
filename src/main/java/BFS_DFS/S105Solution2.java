package BFS_DFS;

public class S105Solution2 {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int max=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max=Math.max(max,backTrace(i,j,grid));
            }
        }
        return max;
    }
    public int backTrace(int x,int y,int[][] grid){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]==0||grid[x][y]==2){
            return 0;
        }
        grid[x][y]=2;
        return backTrace(x-1,y,grid)+backTrace(x+1,y,grid)+backTrace(x,y-1,grid)+backTrace(x,y+1,grid)+1;
    }
}
