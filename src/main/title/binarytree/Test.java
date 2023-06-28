package main.title.binarytree;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(5,null,null);
        TreeNode t2=new TreeNode(4,null,null);
        TreeNode t3=new TreeNode(3,null,t1);
        TreeNode t4=new TreeNode(2,t2,null);
        TreeNode t5=new TreeNode(1,t4,t3);
        L103 res=new L103();
        List<List<Integer>> lists = res.zigzagLevelOrder(t5);
        System.out.println(lists);
    }
}
