package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class L20Solution {
    public boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        HashMap<Character,Character> chash=new HashMap<>();
        chash.put(')','(');
        chash.put(']','[');
        chash.put('}','{');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }else{
                if(stack.peek()!=chash.get(s.charAt(i))){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
