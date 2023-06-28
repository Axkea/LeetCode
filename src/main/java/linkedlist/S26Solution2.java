package linkedlist;

public class S26Solution2 {
    public void reorderList(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null){
            fast=fast.next;
            fast=fast.next;
            if(fast==null){
                break;
            }
            slow=slow.next;
        }
        fast=slow.next;
        slow.next=null;
        ListNode pre=null;
        ListNode after=fast;
        while(fast!=null){
            after=fast.next;
            fast.next=pre;
            pre=fast;
            fast=after;
        }
        //pre fast   not use slow after
        fast=head;
        slow=head.next;
        after=pre;
        while(slow!=null||after!=null){
            if(after!=null){
                fast.next=after;
                fast=fast.next;
                after=after.next;
            }
            if(slow!=null){
                fast.next=slow;
                fast=fast.next;
                slow=slow.next;
            }

        }
    }
}
