package stack;

import java.util.Deque;
import java.util.LinkedList;

public class S31Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack=new LinkedList<>();
        int pushLength=pushed.length,popLength=popped.length;
        int popIndex=0;
        for (int i = 0; i < pushLength; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&popped[popIndex]==stack.peek()){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
