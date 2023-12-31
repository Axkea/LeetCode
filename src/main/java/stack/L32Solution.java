package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L32Solution {
    public int longestValidParentheses(String s) {
        int max=0;
        int n=s.length();
        Deque<Integer> stack=new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()){
                    stack.push(i);
                }else{
                    max=Math.max(max,i-stack.peek());
                }
            }
        }
        return max;
    }
}
