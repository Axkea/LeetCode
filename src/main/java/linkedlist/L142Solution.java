package linkedlist;

public class L142Solution {
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode fast=head, slow=head;
        while((fast!=null&&fast.next!=null)){
            if (fast!=head&&fast==slow){
                break;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        if (fast==slow){
            fast=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return fast;
        }
        return null;
    }
}
