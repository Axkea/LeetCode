package exam;

import java.util.Scanner;

public class Main1 {
    public static int res=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=Integer.parseInt(sc.nextLine());
        int[] data=new int[n];
        boolean[] vis=new boolean[n];
        for (int i = 0; i < n; i++) {
            data[i]=sc.nextInt();
        }
        dfs(vis,data,0,0);
        System.out.println(res);
    }
    public static void  dfs(boolean[] vis,int[] data,int index,int val){
        if(index>=vis.length){
            if (val>res){
                res=val;
            }
            return;
        }
        for (int i = 0; i < 2; i++) {
            //不搜
            if (i==0){
                dfs(vis,data,index+1,val);
            }else{
                if(index>=2&&index<=vis.length-3){
                    if(vis[index-1]==false&&vis[index-2]==false&&vis[index+1]==false&&vis[index+2]==false){
                        vis[index]=true;
                        dfs(vis,data,index+1,val+data[index]);
                        vis[index]=false;
                    }
                }else if(index==1){
                    if(vis[index-1]==false&&vis[index+1]==false&&vis[index+2]==false){
                        vis[index]=true;
                        dfs(vis,data,index+1,val+data[index]);
                        vis[index]=false;
                    }
                }else if(index==0){
                    if(vis[index+1]==false&&vis[index+2]==false){
                        vis[index]=true;
                        dfs(vis,data,index+1,val+data[index]);
                        vis[index]=false;
                    }
                }else if(index==vis.length-2){
                    if(vis[index-1]==false&&vis[index-2]==false&&vis[index+1]==false){
                        vis[index]=true;
                        dfs(vis,data,index+1,val+data[index]);
                        vis[index]=false;
                    }
                }else if(index==vis.length-1){
                    if(vis[index-1]==false&&vis[index-2]==false){
                        vis[index]=true;
                        dfs(vis,data,index+1,val+data[index]);
                        vis[index]=false;
                    }
                }
            }
        }
    }
}
