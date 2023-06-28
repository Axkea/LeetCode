package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L84Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] newHeight=new int[n+2];
        newHeight[0]=0;
        for (int i = 1; i < n+1; i++) {
            newHeight[i]=heights[i-1];
        }
        newHeight[n+1]=0;
        heights=newHeight;
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        int height=0,width=0,maxArea=0,pop=0;
        //维持一个单调递增栈
        for (int i = 1; i < n+2; i++) {
            while(!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                pop=stack.pop();
                height=heights[pop];
                width=i-1-stack.peek();
                maxArea=Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
