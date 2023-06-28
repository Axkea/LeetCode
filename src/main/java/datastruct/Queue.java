package datastruct;

public class Queue<E>{
    private Node head;
    private int num;
    private Node rail;
    public void inQueue(E e){
        Node newNode=new Node(null,e,null);
        if(num==0){
            head=newNode;
            rail=newNode;
            num++;
        }else{
            newNode.pre=rail;
            rail.last=newNode;
            rail=rail.last;
            num++;
        }
    }
    public E deQueue(){
        if(num==0){
            return null;
        }
        if(num==1){
            E e=head.e;
            rail=null;
            head=null;
            num--;
            return e;
        }
        E e=head.e;
        head=head.last;
        num--;
        return e;
    }
    public boolean isEmpty(){
        return num==0;
    }
    public int size(){
        return num;
    }
    private class Node{
        Node pre;
        E e;
        Node last;

        public Node(Node pre, E e, Node last) {
            this.pre = pre;
            this.e = e;
            this.last = last;
        }
    }
}
