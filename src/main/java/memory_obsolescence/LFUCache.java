package memory_obsolescence;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//L460Solution
public class LFUCache {
    private Map<Integer,Node> map;
    private Queue<Node> queue;
    private int capacity;
    private int index;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        if(capacity>0){
            queue=new PriorityQueue<>();
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if(node==null){
            return -1;
        }
        node.index=index++;
        node.seq++;
        queue.remove(node);
        queue.offer(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (capacity==0) return;
        Node node = map.get(key);
        if (node==null){
            if(capacity == map.size()){
                map.remove(queue.remove().key);
            }
            Node newNode=new Node(key,value);
            newNode.index=index++;
            map.put(key,newNode);
            queue.offer(newNode);
        }else{
            node.val=value;
            node.index=index++;
            node.seq++;
            queue.remove(node);
            queue.offer(node);
        }
    }
    class Node implements Comparable<Node>{
        int key;
        int val;
        int seq=1;
        int index;

        public Node() {
        }

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            int freq=this.seq-o.seq;
            return freq==0?this.index-o.index:freq;
        }
    }
}
