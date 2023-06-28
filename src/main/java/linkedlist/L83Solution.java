package linkedlist;

public class L83Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        ListNode res=slow;
        while(fast!=null){
            if (fast.val==slow.val){
                fast=fast.next;
            }else{
                slow.next=fast;
                slow=slow.next;
                fast=fast.next;
            }
        }
        slow.next=null;
        return res;
    }
}
