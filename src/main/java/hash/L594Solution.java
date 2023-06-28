package hash;

import java.util.HashMap;

public class L594Solution {
    public int findLHS(int[] nums) {
        int res=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int num:map.keySet()){
            if(map.containsKey(num+1)){
                res=Math.max(res,map.get(num)+map.get(num+1));
            }
        }
        return res;
    }
}
