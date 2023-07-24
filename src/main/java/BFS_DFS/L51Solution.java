package BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L51Solution {
    private int[] queues;
    private Set<Integer> col=new HashSet<>();
    private Set<Integer> oblique1=new HashSet<>();
    private Set<Integer> oblique2=new HashSet<>();
    private List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        queues=new int[n];
        dfs(0);
        return res;
    }
    private void dfs(int n){
        if (n==queues.length){
            res.add(buildBoard());
            return;
        }
        for (int i = 0; i < queues.length; i++) {
            if (col.contains(i)){
                continue;
            }
            if (oblique1.contains(i+n)){
                continue;
            }
            if (oblique2.contains(i-n)){
                continue;
            }
            col.add(i);
            oblique1.add(i+n);
            oblique2.add(i-n);
            queues[n]=i;
            dfs(n+1);
            col.remove(i);
            oblique1.remove(i+n);
            oblique2.remove(i-n);
            queues[n]=-1;
        }
    }
    private List<String> buildBoard(){
        List<String> res=new ArrayList<>();
        for (int i = 0; i < queues.length; i++) {
            StringBuilder builder=new StringBuilder();
            for (int j = 0; j < queues.length; j++) {
                if (j==queues[i]){
                    builder.append('Q');
                }else{
                    builder.append('.');
                }
            }
            res.add(builder.toString());
        }
        return res;
    }
}
