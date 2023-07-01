package memory_obsolescence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//L146Solution
public class LRUCache {
    private LinkedList<Integer> list;
    private int capacity;
    private Map<Integer,LRUNode> map;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        list=new LinkedList<>();
    }

    public int get(int key) {
        LRUNode lruNode = map.get(key);
        if (lruNode==null){
            return -1;
        }
        Integer keyI=key;
        list.remove(keyI);
        list.push(keyI);
        return lruNode.getVal();
    }

    public void put(int key, int value) {
        LRUNode lruNode = map.get(key);
        if (lruNode==null){
            LRUNode node=new LRUNode(key,value);
            map.put(key,node);
            list.push(key);
        }else{
            lruNode.setVal(value);
            Integer keyI=key;
            list.remove(keyI);
            list.push(keyI);
        }
        if (list.size()>capacity){
            Integer integer = list.removeLast();
            map.remove(integer);
        }
    }

    class LRUNode{
        private int key;
        private int val;

        public LRUNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getKey() {
            return key;
        }
    }
}
