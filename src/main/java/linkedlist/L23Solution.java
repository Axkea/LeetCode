package linkedlist;

import java.util.PriorityQueue;

public class L23Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans=null;
        for (ListNode node:lists){
            ans = merge2List(ans, node);
        }
        return ans;
    }
    private ListNode merge2List(ListNode node1,ListNode node2){
        if (node1==null||node2==null){
            return node1==null?node2:node1;
        }
        ListNode head=new ListNode(0);
        ListNode tail=head,aPtr=node1,bPtr=node2;
        while(aPtr!=null&&bPtr!=null){
            if (aPtr.val< bPtr.val){
                tail.next=aPtr;
                aPtr=aPtr.next;
            }else{
                tail.next=bPtr;
                bPtr=bPtr.next;
            }
            tail=tail.next;
        }
        tail.next=(aPtr!=null?aPtr:bPtr);
        return head.next;
    }
}
