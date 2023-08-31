package linkedlist;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
//
//你应当 保留 两个分区中每个节点的初始相对位置。

public class L86Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode daemon=new ListNode();
        ListNode daemon1=new ListNode(0,head);
        ListNode pointN=daemon;
        ListNode pointH=daemon1;
        while (pointH!=null&&pointH.next!=null){
            if (pointH.next.val<x){
                pointN.next=pointH.next;
                pointN=pointN.next;
                ListNode next=pointH.next.next;
                pointH.next.next=null;
                pointH.next=next;
            }else {
                pointH=pointH.next;
            }
        }
        pointN.next=daemon1.next;
        return daemon.next;
    }
}
