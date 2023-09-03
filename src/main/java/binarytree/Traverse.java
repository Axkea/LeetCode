package binarytree;

import java.util.Deque;
import java.util.LinkedList;

public class Traverse {
    public static void nbt_left(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> stack =new LinkedList<>();
        TreeNode point=root;
        while(!stack.isEmpty()||point!=null){
            if (point!=null){
                System.out.println(point.val);
                stack.push(point);
                point=point.left;
            }else {
                point=stack.pop();
                point=point.right;
            }
        }
    }
    public static void nbt_left1(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode point;
        while(!stack.isEmpty()){
            point = stack.pop();
            System.out.println(point.val);
            if (point.right!=null){
                stack.push(point.right);
            }
            if(point.left!=null){
                stack.push(point.left);
            }
        }
    }
    public static void nbt_mid(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode point=root;
        while(!stack.isEmpty()||point!=null){
            if (point!=null){
                stack.push(point);
                point=point.left;
            }else{
                point=stack.pop();
                System.out.println(point.val);
                point=point.right;
            }
        }
    }
    public static void nbt_right(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> stack1=new LinkedList<>();
        Deque<TreeNode> stack2=new LinkedList<>();
        stack1.push(root);
        TreeNode point;
        while(!stack1.isEmpty()){
            point = stack1.pop();
            stack2.push(point);
            if (point.left!=null){
                stack1.push(point.left);
            }
            if (point.right!=null){
                stack1.push(point.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().val);
        }
    }

}
