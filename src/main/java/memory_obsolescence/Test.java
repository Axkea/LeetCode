package memory_obsolescence;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        LFUCache lruCache=new LFUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.get(1);
        lruCache.put(3,3);
        lruCache.get(2);
        lruCache.get(3);
        lruCache.put(4,4);
        lruCache.get(1);
//        Node1 n2=new Node1(2,2);
//        n2.seq=2;
//        Node1 n1=new Node1(1,1);
//        n1.seq=1;
//        Node1 n3=new Node1(3,3);
//        n3.seq=3;
//        PriorityQueue<Node1> queue=new PriorityQueue<>();
//        queue.add(n2);
//        queue.add(n1);
//        queue.add(n3);
//        while(!queue.isEmpty()){
//            System.out.println(queue.remove());
//        }
    }
}
class Node1 implements Comparable<Node1>{
    int key;
    int val;
    int seq;
    int index;

    public Node1() {
    }

    public Node1(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int compareTo(Node1 o) {
        int freq=this.seq-o.seq;
        return freq==0?this.index-o.index:freq;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", val=" + val +
                '}';
    }
}
