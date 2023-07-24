package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class L56Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> merge=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int l=intervals[i][0],r=intervals[i][1];
            if (i==0||merge.get(merge.size()-1)[1]<l){
                merge.add(new int[]{l,r});
            }else{
                int[] large=merge.get(merge.size()-1);
                large[1]=Math.max(r,large[1]);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}
