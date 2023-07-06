package BFS_DFS;

import java.util.LinkedList;

public class AllTopologySort {
    private LinkedList<Integer>[] tab;
    private int[] inDegree;
    private boolean[] visited;
    private LinkedList<LinkedList<Integer>> topology;
    public LinkedList<LinkedList<Integer>> findAllTopology(int numCourses, int[][] prerequisites) {
        tab=new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            tab[i]=new LinkedList<>();
        }
        inDegree=new int[numCourses];
        visited=new boolean[numCourses];
        topology=new LinkedList<>();
        buildGraph(prerequisites);
        LinkedList<Integer> topo=new LinkedList<>();
        LinkedList<Integer> queue=new LinkedList<>();
        for (int j = 0; j < inDegree.length; j++) {
            if (inDegree[j]==0&&!visited[j]){
                queue.offer(j);
                visited[j]=true;
                findAllTopology(topo,queue);
                visited[j]=false;
                queue.clear();
            }
        }
        return topology;
    }
    private void buildGraph(int[][] prerequisites){
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][1]]++;
            tab[prerequisites[i][0]].offer(prerequisites[i][1]);
        }
    }
    private void findAllTopology(LinkedList<Integer> topo,LinkedList<Integer> queue){
        if (topo.size()== visited.length){
            topology.add(new LinkedList<>(topo));
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            Integer remove = queue.remove(i);
            topo.add(remove);
            for (Integer index :tab[remove]){
                inDegree[index]--;
            }
            int count=0;
            for (int j = 0; j < inDegree.length; j++) {
                if (inDegree[j]==0&&!visited[j]){
                    queue.offer(j);
                    visited[j]=true;
                    count++;
                }
            }
            findAllTopology(topo, queue);
            for (int j = 0; j < count; j++) {
                Integer poll = queue.pollLast();
                visited[poll]=false;
            }
            for (Integer index :tab[remove]){
                inDegree[index]++;
            }
            topo.remove(remove);
            queue.add(i,remove);
        }
    }
}
