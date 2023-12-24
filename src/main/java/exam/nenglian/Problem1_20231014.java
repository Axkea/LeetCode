package exam.nenglian;

import linkedlist.ListNode;

public class Problem1_20231014 {
    public ListNode partition (ListNode pHead, int x) {
        // write code here
        ListNode dummy=new ListNode(0);
        dummy.next=pHead;
        ListNode lessDummy=new ListNode(0);
        ListNode p1=dummy;
        ListNode p2=lessDummy;
        while (p1.next!=null){
            if (p1.next.val<x){
                p2.next=p1.next;
                p1.next=p1.next.next;
                p2=p2.next;
            }else{
                p1=p1.next;
            }
        }
        p2.next=dummy.next;
        return lessDummy.next;
    }
}
