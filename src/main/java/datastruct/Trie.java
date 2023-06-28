package datastruct;

import java.util.HashMap;

public class Trie {
    private Node root;
    class Node{
        boolean exist;
        String value="";
        HashMap<Character,Node> child=new HashMap<>();
    }
    public Trie() {
        root=new Node();
    }

    public void insert(String word) {
        Node currNode=root;
        for (int i = 0; i < word.length(); i++) {
            Node newNode = currNode.child.get(word.charAt(i));
            if(newNode==null){
                 newNode=new Node();
                currNode.child.put(word.charAt(i),newNode);
            }
            currNode=newNode;
        }
        currNode.exist=true;
        currNode.value=word;
    }

    public boolean search(String word) {
        Node currNode=root;
        for (int i = 0; i < word.length(); i++) {
            currNode=currNode.child.get(word.charAt(i));
            if(currNode==null){
                return false;
            }
        }
        return currNode.exist;
    }

    public boolean startsWith(String prefix) {
        Node currNode=root;
        for (int i = 0; i < prefix.length(); i++) {
            currNode=currNode.child.get(prefix.charAt(i));
            if(currNode==null){
                return false;
            }
        }
        return currNode.child.size()!=0|| currNode.exist;
    }
}
