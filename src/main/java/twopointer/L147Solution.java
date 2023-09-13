package twopointer;

import linkedlist.ListNode;

public class L147Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode dummy=new ListNode(0,head);
        ListNode end=head;
        while (end.next!=null){
            ListNode next=end.next;
            if (next.val>=end.val){
                end=next;
                continue;
            }
            end.next=next.next;
            next.next=null;
            ListNode start=dummy;
            while (start!=end){
                if (next.val< start.next.val){
                    ListNode nextOne=start.next;
                    start.next=next;
                    next.next=nextOne;
                    break;
                }
                start=start.next;
            }
        }
        return dummy.next;
    }
}
