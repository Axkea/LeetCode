package BFS_DFS;

import java.util.Deque;
import java.util.LinkedList;

public class L207Solution {
    private LinkedList<Integer>[] tab;
    private int[] inDegree;
    private boolean[] visited;
    private int count;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        tab=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            tab[i]=new LinkedList<>();
        }
        inDegree=new int[numCourses];
        visited=new boolean[numCourses];
        buildGraph(prerequisites);
        return checkCircle();
    }
    private void buildGraph(int[][] prerequisites){
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
            tab[prerequisites[i][0]].offer(prerequisites[i][1]);
        }
    }
    private boolean checkCircle(){
        Deque<Integer> queue=new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i]==0){
                queue.offer(i);
                visited[i]=true;
            }
        }
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            count++;
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
        return count==inDegree.length;
    }
}
