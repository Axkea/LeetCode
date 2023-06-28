package hash;

import java.util.HashMap;

public class L560Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length,pre=0,count=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for (int i = 0; i < n; i++) {
            pre+=nums[i];
            if(map.containsKey(pre-k)){
                count+=map.get(pre-k);
            }
            map.put(pre,map.getOrDefault(pre,0)+1);
        }
        return count;
    }
}
