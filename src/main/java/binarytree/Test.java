package binarytree;

import backtrack.S34Solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
//        TreeNode node1=new TreeNode(1);
//        TreeNode node3=new TreeNode(3);
//        TreeNode node5=new TreeNode(5);
//        TreeNode node7=new TreeNode(7);
//        TreeNode node2=new TreeNode(2,node1,node3);
//        TreeNode node6=new TreeNode(6,node5,node7);
//        TreeNode node4=new TreeNode(4,node2,node6);
//        Traverse.nbt_right(node4);
//        TreeNode node1=new TreeNode(Integer.MIN_VALUE);
//        System.out.println(new L98Solution().isValidBST(node1));
//        ReentrantLock lock=new ReentrantLock();
//        lock.lock();
//        int[] inorder={9,3,15,20,7};
//        int[] postorder={9,15,7,20,3};
//        TreeNode node = new L106Solution().buildTree(inorder, postorder);
//        System.out.println(node);
//        testL107();
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node1=new TreeNode(1,node2,node3);
        testL129(node1);
    }
    public static void pre(TreeNode root){
        TreeNode pointer=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while(pointer!=null||!stack.isEmpty()){
            if(pointer!=null){
                System.out.println(pointer.val);
                stack.push(pointer);
                pointer=pointer.left;
            }else{
                pointer = stack.pop();
                pointer=pointer.right;
            }
        }
    }
    public static void mid(TreeNode root){
        TreeNode pointer=root;
        Deque<TreeNode> stack=new LinkedList<>();
        while(pointer!=null||!stack.isEmpty()){
            if(pointer!=null){
                stack.push(pointer);
                pointer=pointer.left;
            }else{
                pointer = stack.pop();
                System.out.println(pointer.val);
                pointer=pointer.right;
            }
        }
    }
    private static void testL107(){
        TreeNode node1=new TreeNode(1);
        TreeNode node3=new TreeNode(3);
        TreeNode node5=new TreeNode(5);
        TreeNode node7=new TreeNode(7);
        TreeNode node2=new TreeNode(2,node1,node3);
        TreeNode node6=new TreeNode(6,node5,node7);
        TreeNode node4=new TreeNode(4,node2,node6);
        List<List<Integer>> lists = new L107Solution().levelOrderBottom(node4);
        System.out.println(lists);
    }
    private static void testL124(){
        TreeNode node=new TreeNode(-3);
        int i = new L124Solution().maxPathSum(node);
        System.out.println(i);
    }
    private static void testL129(TreeNode root){
        System.out.println(new L129Solution().sumNumbers(root));
    }
}
