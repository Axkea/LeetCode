package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L71Solution {
    public String simplifyPath(String path) {
        StringBuilder builder=new StringBuilder();
        builder.append("/");
        Deque<String> stack=new LinkedList<>();
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            String s=split[i];
            if (s.length()==0||s.equals(".")){
                continue;
            }
            if (s.equals("..")){
                if (!s.isEmpty()){
                    stack.poll();
                }
            }else {
                stack.push(s);
            }
        }
        int size=stack.size();
        for (int i = 0; i < size-1; i++) {
            builder.append(stack.pollLast());
            builder.append("/");
        }
        if (!stack.isEmpty()){
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }
}
