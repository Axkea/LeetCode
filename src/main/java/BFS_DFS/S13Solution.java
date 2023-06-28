package BFS_DFS;

public class S13Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,k,visited);
    }
    private int dfs(int x,int y,int k,boolean[][] visited){
        if(x<0||x>=visited.length||y<0||y>=visited[0].length||countSum(x,y)>k||visited[x][y]){
            return 0;
        }
        visited[x][y]=true;
        return dfs(x+1,y,k,visited)+dfs(x,y+1,k,visited)+1;
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
