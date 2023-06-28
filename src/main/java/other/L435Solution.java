package other;

import java.util.Arrays;
//移除尾部较大的
public class L435Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int high=intervals[0][1],n=intervals.length,res=0;
        for (int i = 1; i < n; i++) {
            if(intervals[i][0]<high){
               if(high>intervals[i][1]){
                   high=intervals[i][1];
               }
               res++;
               continue;
            }
            high=intervals[i][1];
        }
        return res;
    }
}
