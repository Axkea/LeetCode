package linkedlist;

public class L143Solution {
    public void reorderList(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        while (fast!=null&&fast.next!=null){
            fast=fast.next;
            fast=fast.next;
            slow=slow.next;
        }
        ListNode next=slow.next;
        slow.next=null;
        ListNode reverse = reverse(next);
        while (reverse!=null&&head!=null){
            ListNode temp1=reverse.next;
            ListNode temp2=head.next;

            head.next=reverse;
            head=temp2;

            reverse.next=head;
            reverse=temp1;
        }
    }

    private ListNode reverse(ListNode head){
        ListNode next=head,pre=null;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
