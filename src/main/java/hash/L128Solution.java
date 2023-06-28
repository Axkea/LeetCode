package hash;

import java.util.HashSet;

public class L128Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(Integer i:nums){
            set.add(i);
        }
        int max=0;
        for (Integer i:nums){
            if(!set.contains(i-1)){
                int res=0;
                while(set.contains(i)){
                    res++;
                    i++;
                }
                max=Math.max(max,res);
            }
        }
        return max;
    }
}
