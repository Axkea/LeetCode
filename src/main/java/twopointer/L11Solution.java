package twopointer;

public class L11Solution {
    public int maxArea(int[] height) {
        int left=0,n=height.length,right=n-1,maxArea=0;
        while(left!=right){
            int area=0;
            if (height[left]>height[right]){
                area=height[right]*(right-left);
                maxArea=Math.max(maxArea,area);
                right--;
            }else {
                area=height[left]*(right-left);
                maxArea=Math.max(maxArea,area);
                left++;
            }
        }
        return maxArea;
    }
}
