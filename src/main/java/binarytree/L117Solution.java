package binarytree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class L117Solution {
    public Node connect(Node root) {
        if(root==null){
            return null;
        }
        Deque<Node> queue=new LinkedList<>();
        Node p=null;
        queue.add(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            Node pre=null;
            for (int i = 0; i < size; i++) {
                p=queue.pop();
                if(pre==null){
                    pre=p;
                }else{
                    pre.next=p;
                    pre=p;
                }
                if(p.left!=null){
                    queue.add(p.left);
                }
                if(p.right!=null){
                    queue.add(p.right);
                }
            }
        }
        return root;
    }
    public Node connect2(Node root) {
        if(root==null){
            return null;
        }
        Node cur=root;
        while(cur!=null){
            Node dummy=new Node(0);
            Node pre=dummy;
            while(cur!=null){
                if(cur.left!=null){
                    pre.next=cur.left;
                    pre=pre.next;
                }
                if(cur.right!=null){
                    pre.next=cur.right;
                    pre=pre.next;
                }
                cur=cur.next;
            }
            cur=dummy.next;
        }
        return root;
    }
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}

