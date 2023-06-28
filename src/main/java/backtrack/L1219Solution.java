package backtrack;

public class L1219Solution {
    public int getMaximumGold(int[][] grid) {
        int[] res=new int[1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                backTrace(grid,i,j,res,0);
            }
        }
        return res[0];
    }
    private void backTrace(int[][] grid,int x,int y,int[] res,int max){
        if(x>=grid.length||x<0||y<0||y>=grid[0].length||grid[x][y]==0){
            return;
        }
        max+=grid[x][y];
        int temp=grid[x][y];
        grid[x][y]=0;
        if(max>res[0]){
            res[0]=max;
        }
        backTrace(grid,x+1,y,res,max);
        backTrace(grid,x-1,y,res,max);
        backTrace(grid,x,y+1,res,max);
        backTrace(grid,x,y-1,res,max);
        grid[x][y]=temp;
        max-=grid[x][y];
    }
}
