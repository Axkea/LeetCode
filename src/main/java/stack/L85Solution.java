package stack;

import java.util.Deque;
import java.util.LinkedList;

public class L85Solution {
    public int maximalRectangle(char[][] matrix) {
        int rowlen=matrix.length;
        int collen=matrix[0].length;
        int[] dp=new int[collen];
        int maxArea=0;
        for (int i = 0; i < rowlen; i++) {
            for (int j = 0; j < collen; j++) {
                if (matrix[i][j]=='0'){
                    dp[j]=0;
                }else{
                    dp[j]=dp[j]+1;
                }
            }
            maxArea=Math.max(maxArea,getMaxArea(dp));
        }
        return maxArea;
    }
    public int getMaxArea(int[] heights){
        int n=heights.length;
        int[] newHeight=new int[n+2];
        newHeight[0]=-1;
        for (int i = 1; i < n+1; i++) {
            newHeight[i]=heights[i-1];
        }
        newHeight[n+1]=-1;
        heights=newHeight;
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        int maxArea=0,height=0,width=0,pop=0;
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
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
