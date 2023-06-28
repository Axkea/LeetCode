package BFS_DFS;

import java.util.Deque;
import java.util.LinkedList;

public class S13Solution_1 {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return bfs(0,0,k,visited);
    }
    private int bfs(int x,int y,int k,boolean[][] visited){
        int size=0;visited[x][y]=true;
        Deque<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{x,y});
        int[][] position={{1,0},{0,1}};
        while(queue.size()!=0){
            int[] pop = queue.pop();
            size++;
            int xa=pop[0];
            int ya=pop[1];
            for(int[] ints:position){
                int xb=xa+ints[0];
                int yb=ya+ints[1];
                if(xb<0||xb>=visited.length||yb<0||yb>=visited[0].length||countSum(xb,yb)>k||visited[xb][yb]){
                    continue;
                }
                visited[xb][yb]=true;
                queue.offer(new int[]{xb,yb});
            }
        }
        return size;
    }
    private int countSum(int x,int y){
        int res=0;
        while(x!=0){
            res+=x%10;
            x=x/10;
        }
        while(y!=0){
            res+=y%10;
            y=y/10;
        }
        return res;
    }
}
