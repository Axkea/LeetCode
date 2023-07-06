package linkedlist;


public class L25Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy=new ListNode(0);
        ListNode pre=dummy;
        ListNode end=dummy;
        dummy.next=head;
        while (end.next!=null){
            for (int i = 0; i < k&&end!=null; i++) {
                end=end.next;
            }
            if (end==null)break;
            ListNode next=end.next;
            ListNode start=pre.next;
            end.next=null;
            pre.next=reverse(start);
            start.next=next;
            pre=start;
            end=pre;
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode node){
        ListNode pre=null,next=null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }
}
