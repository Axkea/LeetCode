package BFS_DFS;

import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
//        char[][] test={{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
//        L130Solution dfs=new L130Solution();
//        for (char[] chars:test){
//            System.out.println(Arrays.toString(chars));
//        }
//        System.out.println("\n\n");
//        dfs.solve(test);
//        for (char[] chars:test){
//            System.out.println(Arrays.toString(chars));
//        }
//        L329Solution test=new L329Solution();
//        int[][] data={{9,9,4},{6,6,8},{2,1,1}};
//        System.out.println(test.longestIncreasingPath(data));
//        L210Solution solution=new L210Solution();
//        int[][] prerequisites={{1,0}};
//        System.out.println(Arrays.toString(solution.findOrder(2, prerequisites)));

        AllTopologySort topologySort=new AllTopologySort();
        int[][] data={{0,3},{0,2},{2,5},{3,5},{5,7},{5,8},{7,8},{8,9},{1,3},{1,4},{3,6},{4,6},{6,8},{6,9}};
        LinkedList<LinkedList<Integer>> allTopology = topologySort.findAllTopology(10, data);
        for (LinkedList<Integer> list:allTopology){
            System.out.println(list);
        }
        System.out.println(allTopology.size());
    }
}
