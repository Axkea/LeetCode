package linkedlist;

public class S24Solution {
    private ListNode pre;
    private ListNode next;
    public ListNode reverseList(ListNode head) {
        while(head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
