package linkedlist;

public class L2Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=null,head=null;
        int base=0;
        while(l1!=null||l2!=null){
            int left=l1==null?0:l1.val;
            int right=l2==null?0:l2.val;
            int val=left+right+base;
            base=val/10;
            if(head==null){
                head=res=new ListNode(val%10,null);
            }else{
                res.next=new ListNode(val%10,null);
                res=res.next;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        while(base!=0){
            res.next=new ListNode(base,null);
        }
        return head;
    }
}
