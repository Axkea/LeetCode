import binarytree.TreeNode;
import linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author Axkea
 * @Date 2023/11/14/014 23:49
 * @Description
 */
public class ExamExercise {
    public static void main(String[] args) {
//        ListNode n1=new ListNode(1);
//        ListNode n2=new ListNode(2,n1);
//        ListNode n3=new ListNode(3,n2);
//        ListNode n4=new ListNode(4,n3);
//        ListNode n5=new ListNode(5,n4);
//        ListNode reverse = reverse(n5);
//        while (reverse!=null){
//            System.out.println(reverse.val);
//            reverse=reverse.next;
//        }
//        int[] data=new int[]{1,2,4,5,6,7,9};
//        System.out.println(binarySearch(data,6));

    }

    public static ListNode reverse(ListNode head){
        ListNode pre=null,next=head;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static  int binarySearch(int[] data,int target){
        int low=0,high=data.length-1;
        while (low<high){
            int mid=low+(high-low)/2;
            if (data[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return data[low]==target?low:-1;
    }

    public static void nbt_pre(TreeNode root){
        if (root==null){
            return;
        }
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode p=root;
        while (!stack.isEmpty()||p!=null){
            if (p!=null){
                stack.push(p);
                System.out.println(p.val);
                p=p.left;
            }else{
                p=stack.pop();
                p=p.right;
            }
        }
    }
}
