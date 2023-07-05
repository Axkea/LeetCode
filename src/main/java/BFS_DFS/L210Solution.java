package BFS_DFS;

import java.util.*;

public class L210Solution {
    private LinkedList<Integer>[] tab;
    private int[] inDegree;
    private boolean[] visited;
    private List<Integer> order;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        tab=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            tab[i]=new LinkedList<>();
        }
        inDegree=new int[numCourses];
        visited=new boolean[numCourses];
        order=new ArrayList<>();
        buildGraph(prerequisites);
        return findOrder();
    }
    private void buildGraph(int[][] prerequisites){
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            tab[prerequisites[i][1]].offer(prerequisites[i][0]);
        }
    }
    private int[] findOrder(){
        int[] res;
        Deque<Integer> queue=new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0){
                queue.offer(i);
                visited[i]=true;
            }
        }
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            order.add(poll);
            for (Integer i :tab[poll]){
                inDegree[i]--;
            }
            for (int i = 0; i < inDegree.length; i++) {
                if (inDegree[i]==0&&!visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }
        if(order.size()==inDegree.length){
            res=new int[inDegree.length];
            for (int i = 0; i < inDegree.length; i++) {
                res[i]= order.get(i);
            }
            return res;
        }
        return new int[0];
    }
}
