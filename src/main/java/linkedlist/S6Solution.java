package linkedlist;

public class S6Solution {
    public int[] reversePrint(ListNode head) {
        ListNode pre=null;ListNode point=head;
        ListNode next;
        int count=0;
        while(point!=null){
            count++;
            next=point.next;
            point.next=pre;
            pre=point;
            point=next;
        }
        int[] res=new int[count];
        for (int i = 0; i < count; i++) {
            res[i]=pre.val;
            pre=pre.next;
        }
        return res;
    }
}
