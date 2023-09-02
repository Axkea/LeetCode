package linkedlist;

//给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。

public class L92Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode point=dummy;
        ListNode begin=null,end;
        for (int i = 0; i < right; i++) {
            if (i==left-1){
                begin=point;
            }
            point=point.next;
        }
        end=point.next;
        ListNode cur=begin.next;
        begin.next=null;
        point.next=null;
        ListNode reverse = reverse(cur);
        begin.next=reverse;
        cur.next=end;
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre=null;
        ListNode now=head;
        ListNode next=null;
        while (now!=null){
            next=now.next;
            now.next=pre;
            pre=now;
            now=next;
        }
        return pre;
    }
}
