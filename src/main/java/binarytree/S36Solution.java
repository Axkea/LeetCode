package binarytree;

import java.util.ArrayList;
import java.util.List;

public class S36Solution {
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        recursion(root);
        pre.right=head;
        head.left=pre;
        return head;
    }
    public void recursion(Node now){
        if(now==null){
            return;
        }
        recursion(now.left);
        if(head==null){
            head=now;
        }else{
            now.left=pre;
            pre.right=now;
        }
        pre=now;
        recursion(now.right);
    }
}
