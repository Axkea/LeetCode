package twopointer;

import linkedlist.ListNode;

public class L148Solution {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode mid = findMid(head);
        ListNode listNode1 = sortList(mid);
        ListNode listNode2 = sortList(head);
        return merge(listNode1,listNode2);
    }

    private ListNode findMid(ListNode head){
        ListNode dummy=new ListNode(0,head);
        ListNode fast=dummy,slow=dummy;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode mid=slow.next;
        slow.next=null;
        return mid;
    }

    private ListNode merge(ListNode head1,ListNode head2){
        ListNode dummy=new ListNode(0);
        ListNode point=dummy;
        while (head1!=null&&head2!=null){
            if (head1.val< head2.val){
                point.next=head1;
                head1=head1.next;
                point=point.next;
                continue;
            }
            point.next=head2;
            head2=head2.next;
            point=point.next;
        }
        if (head1!=null){
            point.next=head1;
        }
        if (head2!=null){
            point.next=head2;
        }
        return dummy.next;
    }
}
