package stack;

import java.util.Deque;
import java.util.LinkedList;

public class S40Solution_2 {
    public int maximalRectangle(String[] matrix) {
        if(matrix.length==0){
            return 0;
        }
        int l1=matrix.length;
        int l2=matrix[0].length();
        int[] height=new int[l2];
        int maxArea=0;
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if(matrix[i].charAt(j)=='0'){
                    height[j]=0;
                }else{
                    height[j]=height[j]+1;
                }
            }
            maxArea=Math.max(maxArea,maxArea(height));
        }
        return maxArea;
    }
    public int maxArea(int[] heights){
        int num=heights.length;int max=0;
        int[] newHeights=new int[num+2];
        newHeights[0]=newHeights[num+1]=-1;
        for (int i = 1; i <num+1 ; i++) {
            newHeights[i]=heights[i-1];
        }
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for (int i = 1; i <num+2 ; i++) {
            while(!stack.isEmpty()&&newHeights[stack.peek()]>newHeights[i]){
                int j=stack.pop();
                int height=newHeights[j];
                int width=i-1-stack.peek();
                max=Math.max(max,height*width);
            }
            stack.push(i);
        }
        return max;
    }
}
