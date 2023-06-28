package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L1187Solution {
    public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        //对arr2进行去重和排序处理
        Arrays.sort(arr2);
        List<Integer> ilist=new ArrayList<>();
        int pre=-1;
        for(int i:arr2){
            if(i==pre){
                continue;
            }
            ilist.add(i);
            pre=i;
        }
        int n=arr1.length;
        int m=ilist.size();
        int[][] dp=new int[n+1][Math.min(n,m)+1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0]=-1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, m); j++) {
                /* 如果当前元素大于序列的最后一个元素 */
                if (arr1[i - 1] > dp[i - 1][j]) {
                    dp[i][j] = arr1[i - 1];
                }
                if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    /* 查找严格大于 dp[i - 1][j - 1] 的最小元素 */
                    int idx = binarySearch(ilist, j - 1, dp[i - 1][j - 1]);
                    if (idx != ilist.size()) {
                        dp[i][j] = Math.min(dp[i][j], ilist.get(idx));
                    }
                }
                if (i == n && dp[i][j] != Integer.MAX_VALUE) {
                    return j;
                }
            }
        }
        return -1;
    }
    private int binarySearch(List<Integer> ilist,int low,int target){
        int high=ilist.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            int midVal=ilist.get(mid);
            if(midVal==target){
                return mid+1;
            }
            if(midVal>target){
                high=mid-1;
            }
            if(midVal<target){
                low=mid+1;
            }
        }
        return low;
    }
}
