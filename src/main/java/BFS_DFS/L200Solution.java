package BFS_DFS;

public class L200Solution {
    public int numIslands(char[][] grid) {
        int res=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]=='1'){
                    res++;
                    dfs(grid,i,j);
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid,int x,int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]=='0'){
            return;
        }
        grid[x][y]='0';
        dfs(grid,x-1,y);
        dfs(grid,x,y-1);
        dfs(grid,x+1,y);
        dfs(grid,x,y+1);
    }
}
