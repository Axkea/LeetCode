package twopointer;

import linkedlist.ListNode;

import java.util.HashSet;

public class L61Solution {
    public ListNode rotateRight(ListNode head, int k) {
        HashSet<Character> set=new HashSet<>();
        
        if(head==null){
            return null;
        }
        ListNode point=head;
        int num=1;
        while(point.next!=null){
            num++;
            point=point.next;
        }
        point.next=head;
        k=k%num;
        for (int i = 0; i < num-k; i++) {
            point=point.next;
        }
        ListNode res=point.next;
        point.next=null;
        return res;
    }
}
