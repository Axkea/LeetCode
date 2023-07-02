package memory_obsolescence;

public class DoubleEndQueue {
    private Node head;
    private Node tail;
    private int size;

    public DoubleEndQueue() {
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;
    }
    public boolean offerFirst(int key,int val){
        Node newNode=new Node(key,val);
        Node p=head.next;
        head.next=newNode;
        newNode.next=p;
        p.pre=newNode;
        newNode.pre=head;
        size++;
        return true;
    }
    public Node offerLast(int key,int val){
        Node newNode=new Node(key,val);
        Node p=tail.pre;
        tail.pre=newNode;
        newNode.pre=p;
        p.next=newNode;
        newNode.next=tail;
        size++;
        return null;
    }
    public Node peekFirst(){
        if(size==0){
            return null;
        }
        return head.next;
    }
    public Node peekLast(){
        if(size==0){
            return null;
        }
        return tail.pre;
    }
    public Node pollFirst(){
        if(size==0){
            return null;
        }
        Node p=head.next;
        head.next=p.next;
        p.next=null;
        head.next.pre=head;
        p.pre=null;
        size--;
        return p;
    }
    public Node pollLast(){
        if(size==0){
            return null;
        }
        Node p=tail.pre;
        tail.pre=p.pre;
        p.pre=null;
        tail.pre.next=tail;
        p.next=null;
        size--;
        return p;
    }

    class Node{
        private int key;
        private int val;
        private Node pre;
        private Node next;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
