package dp;

import java.util.Arrays;
import java.util.Comparator;

public class J522Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes==null||envelopes.length==0){
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]){
                    return 1;
                }else if (o1[0]<o2[0]) {
                    return -1;
                }
                if(o1[1]>o2[1]) {
                    return -1;
                }
                return 1;
            }
        });
        int[] dp=new int[envelopes.length];
        Arrays.fill(dp,1);int max=1;
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
               if(envelopes[i][1]>envelopes[j][1]){
                   max=Math.max(max,dp[j]+1);
               }
            }
            dp[i]=max;
        }
        return dp[envelopes.length-1];
    }
}
