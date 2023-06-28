package datastruct;

public class Stack<K> {
    private StackNode deep;
    private StackNode top;
    private int num;
    public K peer(){
        if(num==0){
            return null;
        }else{
            return top.k;
        }
    }
    public int size(){
        return num;
    }
    public boolean isEmpty(){
        return num==0;
    }
    public void push(K k){
        StackNode stackNode=new StackNode(null,k,null);
        if(num==0){
            deep=stackNode;
            top=stackNode;
            num++;
        }else{
            stackNode.previous=top;
            top.next=stackNode;
            top=top.next;
            num++;
        }
    }
    public K pop(){
        //判断是否弹不出了
        if(num==0){
            return null;
        }
        //如果只有一个了
        if(num==1){
            StackNode s=top;
            top=null;deep=null;
            num--;
            return s.k;
        }
        StackNode s=top;
        top=top.previous;
        num--;
        return s.k;
    }

    private class StackNode{
        StackNode previous;
        K k;
        StackNode next;

        public StackNode(StackNode previous, K k, StackNode next) {
            this.previous = previous;
            this.k = k;
            this.next = next;
        }

        public void setK(K k) {
            this.k = k;
        }
    }
}
