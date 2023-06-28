package linkedlist;

import java.util.HashMap;

public class S22Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode font=head;
        ListNode back=head;
        for (int i = 0; i < k; i++) {
            font=font.next;
        }
        while(font!=null){
            font=font.next;
            back=back.next;
        }
        return back;
    }
    //只能访问一次节点
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode point=head;
        HashMap<Integer,ListNode> map=new HashMap<>();
        int i;
        for (i= 1; point!=null; i++) {
            map.put(i,point);
            point=point.next;
        }
        return map.get(i-k);
    }
}
