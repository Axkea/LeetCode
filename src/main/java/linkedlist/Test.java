package linkedlist;

import java.util.Arrays;
import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        ListNode head2=new ListNode(2);
        ListNode head3=new ListNode(3);
        ListNode head4=new ListNode(4);
        ListNode head5=new ListNode(5);
        head1.next=head2;
        head2.next=head3;
        head3.next=head4;
        head4.next=head5;
        L25Solution solution=new L25Solution();
        solution.reverseKGroup(head1,2);
//        solution.reverse(head1);
    }
}
