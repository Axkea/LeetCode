package BFS_DFS;

import binarytree.TreeNode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        char[][] test={{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};
        L130Solution dfs=new L130Solution();
        for (char[] chars:test){
            System.out.println(Arrays.toString(chars));
        }
        System.out.println("\n\n");
        dfs.solve(test);
        for (char[] chars:test){
            System.out.println(Arrays.toString(chars));
        }
    }
}
