package datastruct;

public class BinaryTree<Key extends Comparable<Key>,Value> {
    public Node root;
    public int num;
    public Node findMax(){
        return findMax(root);
    }
    private Node findMax(Node node){
        if(node.rightNode==null){
            return node;
        }
        return findMax(node.rightNode);
    }
    public void pre(){
        Stack<Node> s=new Stack();
        Node point=root;
        while(point!=null||!s.isEmpty()){
            if(point!=null){
                System.out.println(point.value);
                s.push(point);
                point=point.leftNode;
            }else{
                point=s.pop();
                point=point.rightNode;
            }
        }
    }
    public void floor(){
        Queue<Node> q=new Queue<>();
        q.inQueue(root);
        Node point;
        while(!q.isEmpty()){
            point= q.deQueue();
            System.out.println(point.value);
            if(point.leftNode!=null){
                q.inQueue(point.leftNode);
            }
            if(point.rightNode!=null){
                q.inQueue(point.rightNode);
            }
        }
    }
    public void mid(){
        Stack<Node> s=new Stack();
        Node point=root;
        while(point!=null||!s.isEmpty()){
            if(point!=null){
                s.push(point);
                point=point.leftNode;
            }else{
                point=s.pop();
                System.out.println(point.value);
                point=point.rightNode;
            }
        }
    }
    public void before(){
        Stack<Node> ro=new Stack<>();
        Stack<Node> res=new Stack<>();
        Node point;
        ro.push(root);
        while(!ro.isEmpty()){
           point=ro.pop();
           res.push(point);
           if(point.leftNode!=null){
               ro.push(point.leftNode);
           }
           if(point.rightNode!=null){
               ro.push(point.rightNode);
           }
        }
        while(res.size()!=0){
            System.out.println(res.pop().value);
        }
    }
    public void search(){
        search(root);
    }
    private void search(Node node){
        if(node==null){
            return ;
        }

        search(node.leftNode);

        search(node.rightNode);
        System.out.println(node);
    }
    public void add(Key key,Value value){
        root=add(root,new Node(value,key,null,null));
    }
    private Node add(Node node,Node aNode){
        if(node==null){
            num++;
            return aNode;
        }
        int temp=node.key.compareTo(aNode.key);
        if(temp>0){
            node.leftNode=add(node.leftNode,aNode);
        }else if(temp<0){
            node.rightNode=add(node.rightNode,aNode);
        }else{
            node.value=aNode.value;
        }
        return node;
    }
    public Node get(Key key){
        return get(key,root);
    }
    private Node get(Key key,Node node){
        //node为空找不到值
        if(node==null){
            return null;
        }
        //比较key与当前节点的值
        int temp=key.compareTo(node.key);
        //比较大小然后做出判断
        if(temp>0){
            return get(key,node.rightNode);
        }else if(temp<0){
            return get(key,node.leftNode);
        }else{
            return node;
        }
    }
    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node node,Key key){
        if(node==null){
            return null;
        }
        int temp=key.compareTo(node.key);
        if(temp>0){
            node.rightNode=delete(node.rightNode,key);
        }else if(temp<0){
            node.leftNode=delete(node.leftNode,key);
        }else{
            if(node.rightNode==null){
                num--;
                return node.leftNode;
            }else{
                Node point=node.rightNode;
                if(point.leftNode==null){
                    num--;
                    point.leftNode=node.leftNode;
                    return point;
                }
                while(point.leftNode.leftNode!=null){
                    point=point.leftNode;
                }
                Node tem=point.leftNode;
                point.leftNode=null;
                tem.leftNode=node.leftNode;
                tem.rightNode=node.rightNode;
                num--;
                return tem;
            }
        }
        return node;
    }
    public void alter(Key key,Value value){
        root=alter(root,key,value);
    }
    public Node alter(Node node,Key key,Value value){
        if(node==null){
            return null;
        }
        int temp=node.key.compareTo(key);
        if(temp>0){
            node.leftNode=alter(node.leftNode,key,value);
        }else if(temp<0){
            node.rightNode=alter(node.rightNode,key,value);
        }else{
            node.value=value;
        }
        return node;
    }
    public class Node{
        public Value value;
        public Key key;
        public Node leftNode;
        public Node rightNode;

        public Node() {
        }

        public Node(Value value, Key key, Node leftNode, Node rightNode) {
            this.value = value;
            this.key = key;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }
    }
}

