package linkedlist;

public class J24Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode point=head;
        ListNode next=null;
        while(point!=null){
            next=point.next;
            point.next=pre;
            pre=point;
            point=next;
        }
        return pre;
    }
}
