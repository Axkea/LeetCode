package linkedlist;

public class L21Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1=list1;ListNode p2=list2;
        ListNode hp=new ListNode(0);ListNode head=hp;
        while(p1!=null||p2!=null){
            if(p1==null){
                hp.next=p2;
                break;
            }
            if (p2==null){
                hp.next=p1;
                break;
            }
            if (p1.val>p2.val){
                hp.next=p2;
                hp=hp.next;
                p2=p2.next;
            }else{
                hp.next=p1;
                hp=hp.next;
                p1=p1.next;
            }
        }
        return head.next;
    }
}
