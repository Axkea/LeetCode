package linkedlist;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(0);
        ListNode head3=new ListNode(2);
        ListNode head4=new ListNode(4);
        ListNode head5=new ListNode(3);
        ListNode head6=new ListNode(2);
        ListNode head7=new ListNode(5);
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        head5.next=head6;
        head6.next=head7;
//        L86Solution solution=new L86Solution();
//        solution.partition(head1,3);
//        solution.reverse(head1);
        ListNode pre=null;
        ListNode next;
        ListNode point=head1;
        while (point!=null){
            next=point.next;
            point.next=pre;
            pre=point;
            point=next;
        }
        System.out.println(pre);
    }
}
