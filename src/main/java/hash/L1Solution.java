package hash;

import java.util.HashMap;

public class L1Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(hashMap.get(nums[i])!=null){
                return new int[]{hashMap.get(nums[i]),i};
            }
            hashMap.put(target-nums[i],i);
        }
        return new int[2];
    }
}
