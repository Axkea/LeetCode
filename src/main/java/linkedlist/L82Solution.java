package linkedlist;


public class L82Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode p=dummy;
        while (p.next!=null&&p.next.next!=null){
            if (p.next.val==p.next.next.val){
                int val=p.next.val;
                while (p.next!=null&&val==p.next.val){
                    p.next=p.next.next;
                }
            }else{
                p=p.next;
            }
        }
        return dummy.next;
    }
}
