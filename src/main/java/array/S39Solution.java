package array;

import java.util.HashMap;
import java.util.Map;

public class S39Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            int num=map.getOrDefault(i,0);
            if(2*num>=nums.length-2){
                return i;
            }
            map.put(i,num+1);
        }
        return 0;
    }
}
