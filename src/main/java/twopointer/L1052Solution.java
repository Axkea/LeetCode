package twopointer;

public class L1052Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //计算出不延迟生气的满意值
        int start=0,end=minutes-1,n=customers.length,res=0,max=0;
        for (int i = 0; i < n; i++) {
            if(grumpy[i]==0){
                res+=customers[i];
            }
        }
        for (int i = 0; i < minutes; i++) {
            if(grumpy[i]==1){
                max+=customers[i];
            }
        }
        int now=max;
        while(end<n-1){
            if(grumpy[start]==1){
                now-=customers[start];
            }
            start++;
            end++;
            if(grumpy[end]==1){
                now+=customers[end];
            }
            max=Math.max(now,max);
        }
        return res+max;
    }
}
