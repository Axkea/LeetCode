package dp;

public class L42Solution {
    public int trap(int[] height) {
        int n=height.length,sum=0;
        int[] leftMax=new int[n];
        int[] rightMax=new int[n];
        leftMax[0]=height[0];
        rightMax[n-1]=height[n-1];
        for (int i = 1; i < n; i++) {
            leftMax[i]=Math.max(leftMax[i-1],height[i]);
            rightMax[n-1-i]=Math.max(rightMax[n-i],height[n-1-i]);
        }
        for (int i = 0; i < n; i++) {
            sum+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return sum;
    }
}
