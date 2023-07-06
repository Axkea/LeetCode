package BFS_DFS;

import java.util.Deque;
import java.util.LinkedList;

public class TopoSort {
    private LinkedList<Integer>[] tab;
    private int[] inDegree;
    private int[] color;
    private LinkedList<Integer> topo;
    public void findTopoByDfs(int numCourses, int[][] prerequisites) {
        tab=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            tab[i]=new LinkedList<>();
        }
        inDegree=new int[numCourses];
        color=new int[numCourses];
        buildGraph(prerequisites);
        topo=new LinkedList<>();
        boolean allTopo = findTopoByDfs(0);
        if (allTopo){
            for (int i = topo.size()-1; i >=0 ; i--) {
                System.out.println(topo.get(i));
            }
        }
        System.out.println("topo has circle");
        return;
    }
    private void buildGraph(int[][] prerequisites){
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
            tab[prerequisites[i][0]].offer(prerequisites[i][1]);
        }
    }
    private boolean findTopoByDfs(int index){
        if (color[index]==1){
            return true;
        }
        if (color[index]==-1){
            return false;
        }
        color[index]=-1;
        for (int i :tab[index]) {
            if (!findTopoByDfs(i)){
                return false;
            }
        }
        color[index]=1;
        topo.add(index);
        return true;
    }
}
