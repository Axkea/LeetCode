package linkedlist;

public class L206Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;ListNode point=head;
        ListNode next;
        while(point!=null){
            next=point.next;
            point.next=pre;
            pre=point;
            point=next;
        }
        return pre;
    }
}
