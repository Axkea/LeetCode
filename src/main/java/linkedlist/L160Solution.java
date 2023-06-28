package linkedlist;

public class L160Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pa=headA;int count_a=0;
        ListNode pb=headB;int count_b=0;
        while(pa!=null){
            count_a++;
            pa=pa.next;
        }
        while(pb!=null){
            count_b++;
            pb=pb.next;
        }
        pa=headA;pb=headB;
        if (count_a>count_b){
            int sub=count_a-count_b;
            for (int i = 0; i < sub; i++) {
                pa=pa.next;
            }
            while (pa!=null){
                if (pa==pb){
                    return pa;
                }else{
                    pa=pa.next;
                    pb=pb.next;
                }
            }
        }else {
            int sub=count_b-count_a;
            for (int i = 0; i < sub; i++) {
                pb=pb.next;
            }
            while (pa!=null){
                if (pa==pb){
                    return pa;
                }else{
                    pa=pa.next;
                    pb=pb.next;
                }
            }
        }
        return null;
    }
}
