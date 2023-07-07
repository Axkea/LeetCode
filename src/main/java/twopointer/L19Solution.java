package twopointer;

import linkedlist.ListNode;

public class L19Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode first=dummy,sec=dummy;
        for (int i = 0; i < n; i++) {
            sec=sec.next;
        }
        while(sec.next!=null){
            first=first.next;
            sec=sec.next;
        }
        first.next=first.next.next;
        return dummy.next;
    }
}
