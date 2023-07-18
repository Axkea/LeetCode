package linkedlist;

public class L24Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode pre=dummy;
        ListNode end=dummy;
        while(end.next!=null){
            for (int i = 0; i < 2&&end!=null; i++) {
                end=end.next;
            }
            if (end==null){
                break;
            }
            ListNode next=end.next;
            ListNode start=pre.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre=null,next=head;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
