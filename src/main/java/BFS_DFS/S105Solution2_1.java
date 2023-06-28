package BFS_DFS;

import java.util.Deque;
import java.util.LinkedList;

public class S105Solution2_1 {
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    max=Math.max(max,bfs(i,j,grid));
                }
            }
        }
        return max;
    }
    private int bfs(int x,int y,int[][] grid){
        int res=0;
        Deque<int[]> queue=new LinkedList();
        queue.offer(new int[]{x,y});
        grid[x][y]=0;
        int[][] position={{1,0},{-1,0},{0,1},{0,-1}};
        while(queue.size()!=0){
            int[] pop = queue.pop();
            res++;
            int a=pop[0];
            int b=pop[1];
            for(int[] ints:position){
                a=a+ints[0];
                b=b+ints[1];
                if(a<0||a>= grid.length||b<0||b>=grid[0].length||grid[a][b]==0){
                    a=pop[0];
                    b=pop[1];
                    continue;
                }
                grid[a][b]=0;
                queue.offer(new int[]{a,b});
                a=pop[0];
                b=pop[1];
            }
        }
        return res;
    }
}
